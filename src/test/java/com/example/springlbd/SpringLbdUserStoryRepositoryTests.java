package com.example.springlbd;

import com.example.springlbd.entity.userstory.UserStory;
import com.example.springlbd.repositories.userstory.UserStoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class SpringLbdUserStoryRepositoryTests {

    @Autowired
    UserStoryRepository userStoryRepository;

    @Test
    void givenDataCreated_whenFindAllPaginated_thenSuccess(){
        Page<UserStory> retrivedUserStories = userStoryRepository.findAll(PageRequest.of(0,3));
        assertThat(retrivedUserStories.getContent(),hasSize(3));
    }

}
