package com.example.springlbd;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import com.example.springlbd.services.SprintService;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Autowired
    UserStoryRepository userStoryRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Test
    void whenSavingNewSprint_thenSuccess(){
        Sprint sprint = new Sprint(
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
                LocalDate.of(2000,1,1),
                LocalDate.of(1999,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        assertThrows(IllegalArgumentException.class,() -> sprintService.saveSprint(sprint));
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

        Set<SprintDto> sprintSet = sprintService.getSprintsBetweenDates(LocalDate.of(1601,1,1),LocalDate.of(1702,1,1));

        assertEquals(sprintSet.size(),1);
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
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Review,
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

        assert (points==150L);
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
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Review,
                                null
                        )
                ))
        );

        Sprint s=sprintService.saveSprintAndUserStories(sprint,sprint.getUserStories());
        assertNotNull(s);
    }

    @Test
    void whenFindAllWithOrWithoutUserStories(){

        final Sprint sprint = new Sprint(
                2L,
                "sprint1",
                LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1),
                "opis",
                SprintStatus.In_progress,
                new HashSet<>(Arrays.asList(
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Done,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                null,
                                30L,
                                UserStoryStatus.Review,
                                null
                        )
                ))
        );

        userStoryRepository.saveAll(sprint.getUserStories());
        sprintRepository.save(sprint);

        Set<SprintDto> sprintDtos=sprintService.findAllWithOrWithoutUserStories(false);

        assert (sprintDtos.stream().allMatch(x -> x.getUserStories()==null));

        sprintDtos=sprintService.findAllWithOrWithoutUserStories(true);

        Optional<SprintDto> sprintDto=sprintDtos.stream().filter(x-> x.getName()=="sprint1").findFirst();

        assert sprintDto.isPresent();

        assert sprintDto.get().getUserStories().size()==sprint.getUserStories().size();

    }



}
