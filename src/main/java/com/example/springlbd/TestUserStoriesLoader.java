package com.example.springlbd;

import com.example.springlbd.entity.userstory.Status;
import com.example.springlbd.entity.userstory.UserStory;
import com.example.springlbd.repositories.userstory.UserStoryRepository;
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
            repository.save(new UserStory(
             UUID.randomUUID().toString(),
             UUID.randomUUID().toString(),
             (long)random.nextInt(100),
             Status.values()[random.nextInt(3)],
            null
            ));
        }
    }

}
