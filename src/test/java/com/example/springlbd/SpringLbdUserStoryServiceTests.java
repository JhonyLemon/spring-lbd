package com.example.springlbd;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SpringLbdUserStoryServiceTests {

    @Autowired
    UserStoryService userStoryService;

    @Test
    void whenSavingNewUserStory_thenSuccess(){
        UserStory story = new UserStory(
                "name",
                "gfjsdsf",
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
                30L,
                UserStoryStatus.In_progress,
                null
        );
        assertThrows(IllegalArgumentException.class,() -> userStoryService.saveUserStory(story));
    }

}
