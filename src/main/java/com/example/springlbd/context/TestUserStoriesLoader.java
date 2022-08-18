package com.example.springlbd.context;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class TestUserStoriesLoader implements ApplicationContextAware {

    @Autowired
    UserStoryRepository repository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        Random random = new Random();
        for (Integer i=0; i<100; i++){
            repository.save(UserStory.builder()
                    .name(UUID.randomUUID().toString())
                    .description(UUID.randomUUID().toString())
                    .userStoryStatus(UserStoryStatus.values()[random.nextInt(3)])
                    .storyPoints((long)random.nextInt(100))
                    .build());
        }
    }

}
