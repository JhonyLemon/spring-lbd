package com.example.springlbd;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SpringLbdUserStoryServiceTests {

    @Autowired
    UserStoryService userStoryService;

    @Autowired
    SprintRepository sprintRepository;

    @Test
    void whenSavingNewUserStory_thenSuccess(){
        UserStory story = new UserStory(
                "name",
                "gfjsdsf",
                null,
                30L,
                UserStoryStatus.In_progress,
                null
        );
        assertNotNull(userStoryService.saveUserStory(story));
    }

    @Test
    void whenSavingNewUserStory_thenFailure(){
        UserStory story = new UserStory(
                "name",
                null,
                null,
                30L,
                UserStoryStatus.In_progress,
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
            userStoryService.saveUserStory(u);
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

}
