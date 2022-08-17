package com.example.springlbd.services;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.events.UserStoryCreatedEvent;
import com.example.springlbd.mapper.SprintMapper;
import com.example.springlbd.mapper.UserStoryMapper;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;
    private final UserStoryRepository userStoryRepository;
    private final SprintMapper sprintMapper;
    private final UserStoryMapper userStoryMapper;

    public List<SprintDto> findAllWithOrWithoutUserStories(Boolean tasks){
        if(tasks){
            return sprintMapper.SprintIterableToSprintDtoListUserStoryOnlyNamePointsToSprintDto(sprintRepository.findAllFetchUserStories());
        }else{
            return sprintMapper.SprintIterableToSprintDtoListWithoutConstraints(sprintRepository.findAll());
        }

    }

    @Transactional
    public void addUserStoryToSprint(Long id, UserStoryDto userStoryDto){
        sprintRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("Sprint o podanym id nie istnieje"))
                .getUserStories()
                .add(userStoryMapper.UserStoryDtoToUserStory(userStoryDto));
    }

    public Long countStoryPointsBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        return sprintRepository
                .countStoryPointsBySprintId(id)
                .orElseThrow(()->new EntityNotFoundException("Sprint o podanym id nie istnieje lub nie ma przypisanych user stories"));
    }

    public List<UserStoryDto> getUserStoriesBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        return userStoryMapper
                .UserStoryListToUserStoryDtoListIgnoreAttachmentsAndDescription(sprintRepository
                .findUserStoriesById(id)
                .orElseThrow(()->new EntityNotFoundException("Sprint o podanym id nie istnieje lub nie ma przypisanych user stories")));
    }

    @Transactional
    public void updateSprintStatus(Long id, SprintStatus status){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        sprintRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("Sprint o podanym id nie istnieje"))
                .setSprintStatus(status);
    }

    public List<SprintDto> getSprintsBetweenDates(LocalDate start, LocalDate stop){
        if(start.isAfter(stop))
            throw new IllegalArgumentException("Data początku musi być przed data końca");
        return sprintMapper
                .SprintListToSprintDtoListIgnoreAllExceptNameDatesStatus(sprintRepository
                .findByBeginDateGreaterThanEqualAndEndDateLessThanEqual(start,stop)
                .orElseThrow(()-> new EntityNotFoundException("Nie znaleziono sprintów pomiędzy datami("+start+"-"+stop+")")));
    }

    @EventListener
    @Transactional
    public void handleUserStoryCreatedEvent(UserStoryCreatedEvent userStoryCreatedEvent){
        Optional<Sprint> optionalSprint=sprintRepository.findRecentWithPendingStatus();
        if(!optionalSprint.isPresent())
            throw new EntityNotFoundException("Sprint nie istnieje");
        optionalSprint.get().getUserStories().add(userStoryCreatedEvent.getUserStory());
    }

}
