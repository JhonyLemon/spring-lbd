package com.example.springlbd;

import com.example.springlbd.entity.sprint.Sprint;
import com.example.springlbd.entity.sprint.Status;
import com.example.springlbd.entity.userstory.UserStory;
import com.example.springlbd.services.sprint.SprintService;
import com.example.springlbd.services.userstory.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringLbdSprintServiceTests {

    @Autowired
    SprintService sprintService;

    @Autowired
    UserStoryService userStoryService;

    @Test
    void whenSavingNewSprint_thenSuccess(){
        Sprint sprint = new Sprint(
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                Status.In_progress,
                null
        );
        assertNotNull(sprintService.saveSprint(sprint));
    }

    @Test
    void whenSavingNewSprint_thenFailure(){
        Sprint sprint = new Sprint(
                null,
                LocalDate.of(2000,1,1),
                LocalDate.of(1999,1,1),
                "opis",
                Status.In_progress,
                null
        );
        assertThrows(IllegalArgumentException.class,() -> sprintService.saveSprint(sprint));
    }

    @Test
    void whenGettingUserStoryBySprintId(){
        final Sprint sprint = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                Status.In_progress,
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        )
                ))
        );

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
                Status.In_progress,
                null
        );
        Sprint sprint2 = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(1602,1,1),
                LocalDate.of(1701,1,1),
                "opis",
                Status.In_progress,
                null
        );
        Sprint sprint3 = new Sprint(
                3L,
                "sprint1",
                LocalDate.of(1602,1,1),
                LocalDate.of(1801,1,1),
                "opis",
                Status.In_progress,
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
                Status.In_progress,
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Review,
                                null
                        )
                ))
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
                Status.In_progress,
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                com.example.springlbd.entity.userstory.Status.Review,
                                null
                        )
                ))
        );

        Sprint s=sprintService.saveSprintAndUserStories(sprint,List.copyOf(sprint.getUserStories()));
        assertNotNull(s);
    }

    @Test
    void givenDataCreated_whenFindAllPaginatedAndSort_thenSuccess(){

        Random random =new Random();

        for(Integer i=0; i<10; i++)
        {
            sprintService.saveSprint(new Sprint(
                    UUID.randomUUID().toString(),
                    LocalDate.of(random.nextInt(2050-1900)+1900,random.nextInt(12-1)+1,random.nextInt(31-1)+1),
                    LocalDate.of(random.nextInt(2070-2060)+2060,random.nextInt(12-1)+1,random.nextInt(31-1)+1),
                    UUID.randomUUID().toString(),
                    Status.values()[random.nextInt(3)],
                    null
            ));
        }
        Sprint sprint = new Sprint(
                "kjjv",
                LocalDate.of(2100,1,1),
                LocalDate.of(2200,1,1),
                "opis",
                Status.In_progress,
                null
        );
        sprintService.saveSprint(sprint);

        List<Sprint> retrivedSprints = sprintService
                .findAllPaginated(PageRequest
                        .of(
                                0,
                                3,
                                Sort.by(Sort.Order.desc("beginDate"))));

        assert (retrivedSprints.size()==3 &&
                retrivedSprints.get(0).getBeginDate().equals(sprint.getBeginDate())
        );
    }


}
