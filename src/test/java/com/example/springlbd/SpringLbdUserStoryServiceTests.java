package com.example.springlbd;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.mapper.UserStoryMapper;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SpringLbdUserStoryServiceTests {

    @Autowired
    UserStoryService userStoryService;

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    UserStoryRepository userStoryRepository;

    @Autowired
    UserStoryMapper userStoryMapper;

    @Test
    void whenSavingNewUserStory_thenSuccess(){
        UserStoryDto story = new UserStoryDto(
                "name",
                "gfjsdsf",
                30L,
                UserStoryStatus.In_progress,
                null,
                null
        );
        assertNotNull(userStoryService.saveUserStory(story));
    }

    @Test
    void whenSavingNewUserStory_thenFailure(){
        UserStoryDto story = new UserStoryDto(
                "name",
                null,
                30L,
                UserStoryStatus.In_progress,
                null,
                null
        );
        assertThrows(IllegalArgumentException.class,() -> userStoryService.saveUserStory(story));
    }

    @Test
    void whenGettingUserStoryBySprintId(){
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
                                UserStoryStatus.In_progress,
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
                                UserStoryStatus.In_progress,
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
                                UserStoryStatus.In_progress,
                                null
                        )
                ))
        );

        for (UserStory u :
                sprint.getUserStories()) {
            userStoryRepository.save(u);
        }
        sprintRepository.save(sprint);

        Set<UserStoryDto> userStoryList = userStoryService.getUserStoriesBySprintId(2L);

        assert (
                userStoryList.size()==sprint.getUserStories().size() &&
                        userStoryList.stream()
                                .allMatch( a -> sprint.getUserStories().stream()
                                        .anyMatch(b -> a.getId().equals(b.getId())))
        );
    }

    @Test
    void whenGetSortedByNamePage() {

        List<UserStory> userStories = new ArrayList<>(Arrays.asList(
                new UserStory(
                        "1",
                        "gfjsdsf",
                        null,
                        30L,
                        UserStoryStatus.In_progress,
                        null
                ),
                new UserStory(
                        "2",
                        "gfjsdsf",
                        null,
                        30L,
                        UserStoryStatus.In_progress,
                        null
                ),
                new UserStory(
                        "3",
                        "gfjsdsf",
                        null,
                        30L,
                        UserStoryStatus.In_progress,
                        null
                ),
                new UserStory(
                        "4",
                        "gfjsdsf",
                        null,
                        30L,
                        UserStoryStatus.In_progress,
                        null
                ),
                new UserStory(
                        "5",
                        "gfjsdsf",
                        null,
                        30L,
                        UserStoryStatus.In_progress,
                        null
                )
        ));

            userStoryRepository.saveAll(userStories);
        List<UserStoryDto> userStoryDtos =userStoryService.getSortedByNamePage(2,0);
        UserStoryDto userStoryDtos1 =userStoryService.getSortedByNamePage(1,0).get(0);
        UserStoryDto userStoryDtos2 =userStoryService.getSortedByNamePage(1,1).get(0);
        assert (userStoryDtos.get(0).getId().equals(userStoryDtos1.getId()) && userStoryDtos.get(1).getId().equals(userStoryDtos2.getId()));
    }

}
