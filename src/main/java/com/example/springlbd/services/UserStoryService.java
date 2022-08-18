package com.example.springlbd.services;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;


    @Transactional
    public UserStory saveUserStory(UserStory userStory){
        if(userStory.getName()==null)
            throw new IllegalArgumentException("Pole nazwy user story nie może być puste");
        if(userStory.getDescription()==null)
            throw new IllegalArgumentException("Pole opisu user story nie może być puste");
        if(userStory.getUserStoryStatus()==null)
            userStory.setUserStoryStatus(UserStoryStatus.To_do);

        return userStoryRepository.save(userStory);
    }
    public List<UserStory> findAllPaginated(Pageable pageable){
        Page<UserStory> retrivedUserStories = userStoryRepository.findAll(pageable);
        return retrivedUserStories.getContent();
    }

}
