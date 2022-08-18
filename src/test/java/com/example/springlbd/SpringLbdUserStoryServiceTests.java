package com.example.springlbd;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DependsOnDatabaseInitialization
public class SpringLbdUserStoryServiceTests {

    @Autowired
    UserStoryService userStoryService;

    @Test
    void whenSavingNewUserStory_thenSuccess(){

        UserStory story = UserStory.builder()
                .name("name")
                .description("gfjsdsf")
                .storyPoints(30L)
                .userStoryStatus(UserStoryStatus.In_progress)
                .build();
        assertNotNull(userStoryService.saveUserStory(story));
    }

    @Test
    void whenSavingNewUserStory_thenFailure(){
        UserStory story = UserStory.builder()
                .name("name")
                .description(null)
                .storyPoints(30L)
                .userStoryStatus(UserStoryStatus.In_progress)
                .build();
        assertThrows(IllegalArgumentException.class,() -> userStoryService.saveUserStory(story));
    }

    @Test
    void givenDataCreated_whenFindAllPaginated_thenSuccess(){
        List<UserStory> retrivedUserStories = userStoryService.findAllPaginated(PageRequest.of(0,3));
        assertThat(retrivedUserStories,hasSize(3));
    }


}
