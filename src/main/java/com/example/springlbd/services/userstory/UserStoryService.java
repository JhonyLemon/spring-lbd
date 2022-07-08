package com.example.springlbd.services.userstory;

import com.example.springlbd.entity.userstory.Status;
import com.example.springlbd.entity.userstory.UserStory;
import com.example.springlbd.repositories.userstory.UserStoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
            userStory.setStatus(Status.To_do);

        return userStoryRepository.save(userStory);
    }
    public List<UserStory> findAllPaginated(Pageable pageable){
        Page<UserStory> retrivedUserStories = userStoryRepository.findAll(pageable);
        return retrivedUserStories.getContent();
    }

}
