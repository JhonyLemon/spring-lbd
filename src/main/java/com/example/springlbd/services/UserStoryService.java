package com.example.springlbd.services;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserStoryService {

    private UserStoryRepository userStoryRepository;

    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Transactional
    public UserStory saveUserStory(UserStory userStory){
        if(userStory.getName()==null)
            throw new IllegalArgumentException("Pole nazwy user story nie może być puste");
        if(userStory.getDescription()==null)
            throw new IllegalArgumentException("Pole opisu user story nie może być puste");
        if(userStory.getStatus()==null)
            userStory.setStatus(UserStoryStatus.To_do);

        return userStoryRepository.save(userStory);
    }

}
