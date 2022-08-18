package com.example.springlbd;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.services.SprintService;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DependsOnDatabaseInitialization
public class SpringLbdSprintServiceTests {

    @Autowired
    SprintService sprintService;

    @Autowired
    UserStoryService userStoryService;

    @Test
    void whenSavingNewSprint_thenSuccess(){
        Sprint sprint = new Sprint(
                null,
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        assertNotNull(sprintService.saveSprint(sprint));
    }

    @Test
    void whenSavingNewSprint_thenFailure(){
        Sprint sprint = new Sprint(
                null,
                null,
                LocalDate.of(2000,1,1),
                LocalDate.of(1999,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        assertThrows(IllegalArgumentException.class,() -> sprintService.saveSprint(sprint));
    }

    @Test
    void whenGettingUserStoryBySprintId(){

        final Sprint sprint =         Sprint.builder()
                .id(2L)
                .name("sprint1")
                .beginDate(LocalDate.of(2000,1,1))
                .endDate(LocalDate.of(2001,1,1))
                .goalDescription("opis")
                .sprintStatus(SprintStatus.In_progress)
                .userStories(Arrays.asList(
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.In_progress)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.In_progress)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.In_progress)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.In_progress)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.In_progress)
                                .build()
                ))
                .build();

        for (UserStory u :
                sprint.getUserStories()) {
            userStoryService.saveUserStory(u);
        }
        sprintService.saveSprint(sprint);

        List<UserStory> userStoryList = sprintService.getUserStories(2L);


        assert (
            userStoryList.size()==sprint.getUserStories().size() &&
                    userStoryList.stream()
                            .allMatch( a -> sprint.getUserStories().stream()
                                    .anyMatch(b -> a.getId().equals(b.getId())))
        );
    }

    @Test
    void whenGettingUserStoryBetweenDates(){
        Sprint sprint1 = new Sprint(
                1L,
                "sprint1",
                LocalDate.of(1502,1,1),
                LocalDate.of(1701,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        Sprint sprint2 = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(1602,1,1),
                LocalDate.of(1701,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        Sprint sprint3 = new Sprint(
                3L,
                "sprint1",
                LocalDate.of(1602,1,1),
                LocalDate.of(1801,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );


        sprint1= sprintService.saveSprint(sprint1);
        sprint2=sprintService.saveSprint(sprint2);
        sprint3=sprintService.saveSprint(sprint3);

        List<Sprint> sprintSet = sprintService.getSprintsBetweenDates(LocalDate.of(1601,1,1),LocalDate.of(1702,1,1));

        assertEquals(sprintSet.get(0).getId(),sprint2.getId());
    }

    @Test
    void whenGettingStoryPointsBySprintId(){
        final Sprint sprint = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                SprintStatus.In_progress,
                Arrays.asList(
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Review,
                                null
                        )
                )
        );

        for (UserStory u :
                sprint.getUserStories()) {
            userStoryService.saveUserStory(u);
        }
        sprintService.saveSprint(sprint);

        Long points = sprintService.countStoryPointsBySprintId(2L);

        assert (points==90L);
    }

    @Test
    void whenSavingNewSprintAndUserStories(){

        final Sprint sprint = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                SprintStatus.In_progress,
                Arrays.asList(
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                null,
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Review,
                                null
                        )
                )
        );
        Sprint s=sprintService.saveSprintAndUserStories(sprint,List.copyOf(sprint.getUserStories()));
        assertNotNull(s);
    }



}
