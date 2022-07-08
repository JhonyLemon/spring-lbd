package com.example.springlbd.context;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class TestUserStoriesLoader implements ApplicationContextAware {

    @Autowired
    UserStoryRepository repositoryu;

    @Autowired
    SprintRepository repositorys;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        Random random = new Random();
        Sprint sprint = new Sprint(
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
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        ),
                        new UserStory(
                                "name",
                                "gfjsdsf",
                                30L,
                                UserStoryStatus.In_progress,
                                null
                        )
                ))
        );

        for (UserStory u :
                sprint.getUserStories()) {
            repositoryu.save(u);
        }
        repositorys.save(sprint);

        Set<UserStory> userStorySet= new HashSet<>();
        for (Integer i=0; i<100; i++){

            repositoryu.save(new UserStory(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    (long)random.nextInt(100),
                    UserStoryStatus.values()[random.nextInt(3)],
                    null
            ));
        }

    }

}
