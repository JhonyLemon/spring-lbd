package com.example.springlbd.services;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.events.UserStoryCreatedEvent;
import com.example.springlbd.mapper.UserStoryMapper;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserStoryService {

    private UserStoryRepository userStoryRepository;
    private SprintRepository sprintRepository;

    private UserStoryMapper userStoryMapper;

    private ApplicationEventPublisher applicationEventPublisher;

    public UserStoryService(UserStoryRepository userStoryRepository,
                            UserStoryMapper userStoryMapper,
                            SprintRepository sprintRepository,
                            ApplicationEventPublisher applicationEventPublisher) {
        this.userStoryRepository = userStoryRepository;
        this.userStoryMapper =userStoryMapper;
        this.sprintRepository =sprintRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public UserStoryDto saveUserStory(UserStoryDto userStoryDto){
        if(userStoryDto.getName()==null)
            throw new IllegalArgumentException("Pole nazwy user story nie może być puste");
        if(userStoryDto.getDescription()==null)
            throw new IllegalArgumentException("Pole opisu user story nie może być puste");
        if(userStoryDto.getUserStoryStatus()==null)
            userStoryDto.setUserStoryStatus(UserStoryStatus.To_do);
        UserStory userStory=userStoryRepository.save(userStoryMapper.mapDtoToEntity(userStoryDto));
        applicationEventPublisher.publishEvent(new UserStoryCreatedEvent(userStory.getId()));
        return userStoryMapper.mapEntityToDtoWithoutConstraints(userStory);
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

    @Transactional
    public void deleteUserStoryById(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<UserStory> optionalUserStory= userStoryRepository.findById(id);
        if(!optionalUserStory.isPresent())
            throw new EmptyResultDataAccessException("User story o podanym id nie istnieje",0);
        optionalUserStory.get().getSprints().forEach(x -> x.getUserStories().remove(optionalUserStory.get()));
        userStoryRepository.delete(optionalUserStory.get());
    }

    public List<UserStoryDto> getSortedByNamePage(Integer pageSize, Integer pageNumber){
        Page<UserStory> userStoryPage = userStoryRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by("name").ascending()));
        return userStoryMapper.mapUserStoryListToDtoListWithoutConstraints(userStoryPage.getContent());
    }




}
