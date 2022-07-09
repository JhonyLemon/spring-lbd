package com.example.springlbd.services;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.mapper.UserStoryMapper;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserStoryService {

    private UserStoryRepository userStoryRepository;
    private SprintRepository sprintRepository;

    private UserStoryMapper userStoryMapper;

    public UserStoryService(UserStoryRepository userStoryRepository, UserStoryMapper userStoryMapper,SprintRepository sprintRepository) {
        this.userStoryRepository = userStoryRepository;
        this.userStoryMapper =userStoryMapper;
        this.sprintRepository =sprintRepository;
    }

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

    @Transactional
    public UserStoryDto addUserStoryToSprint(Long id,UserStoryDto userStoryDto){

        Optional<Sprint> optional=sprintRepository.findById(id);
        if (!optional.isPresent())
            throw new EmptyResultDataAccessException("Sprint o podanym id nie istnieje",0);


        UserStory userStory =userStoryMapper.mapDtoToEntity(userStoryDto);
        userStory.setSprints(new HashSet<>(Arrays.asList(optional.get())));
        optional.get().getUserStories().add(userStory);
        userStory = userStoryRepository.save(userStory);

        UserStoryDto dto = userStoryMapper.mapEntityToDtoWithoutConstraints(userStory);
        return dto;
    }

    public Set<UserStoryDto> getUserStoriesBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<Set<UserStory>> optional= sprintRepository.findUserStoriesById(id);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("Sprint o podanym id nie istnieje lub nie ma przypisanych user stories",0);
        return userStoryMapper.mapEntityToDtoIgnoreAttachmentsAndDescription(optional.get());
    }

    public String getUserStoryDescriptionById(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<String> optional= userStoryRepository.findUserStoryDescriptionById(id);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("User story o podanym id nie istnieje",0);
        return optional.get();
    }


}
