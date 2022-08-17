package com.example.springlbd;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import com.example.springlbd.services.SprintService;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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


        sprint1= sprintRepository.save(sprint1);
        sprint2=sprintRepository.save(sprint2);
        sprint3=sprintRepository.save(sprint3);

        List<SprintDto> sprintSet = sprintService.getSprintsBetweenDates(LocalDate.of(1601,1,1),LocalDate.of(1702,1,1));

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

                new ArrayList<>(Arrays.asList(
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build()
                ))
        );

        for (UserStory u :
                sprint.getUserStories()) {
            userStoryRepository.save(u);
        }
        sprintRepository.save(sprint);

        Long points = sprintService.countStoryPointsBySprintId(2L);

        assert (points==150L);
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
                new ArrayList<>(Arrays.asList(
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build(),
                        UserStory.builder()
                                .name("name")
                                .description("gfjsdsf")
                                .storyPoints(30L)
                                .userStoryStatus(UserStoryStatus.Done)
                                .build()
                ))
        );

        userStoryRepository.saveAll(sprint.getUserStories());
        sprintRepository.save(sprint);

        List<SprintDto> sprintDtos=sprintService.findAllWithOrWithoutUserStories(false);

        assert (sprintDtos.stream().allMatch(x -> x.getUserStories()==null));

        sprintDtos=sprintService.findAllWithOrWithoutUserStories(true);

        Optional<SprintDto> sprintDto=sprintDtos.stream().filter(x-> x.getName()=="sprint1").findFirst();

        assert sprintDto.isPresent();

        assert sprintDto.get().getUserStories().size()==sprint.getUserStories().size();

    }
}
