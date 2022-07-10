package com.example.springlbd.services;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.mapper.SprintMapper;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

import java.util.Optional;
import java.util.Set;

@Service
public class SprintService {
        private SprintRepository sprintRepository;

    private UserStoryRepository userStoryRepository;

    private SprintMapper sprintMapper;

    public SprintService(SprintRepository sprintRepository,UserStoryRepository userStoryRepository,SprintMapper sprintMapper) {
        this.sprintRepository = sprintRepository;
        this.userStoryRepository=userStoryRepository;
        this.sprintMapper=sprintMapper;
    }

    @Transactional
    public Sprint saveSprint(Sprint sprint){
        if(sprint.getBeginDate()==null)
            throw new IllegalArgumentException("Pole daty początkowej nie może być puste");
        if(sprint.getEndDate()==null)
            throw new IllegalArgumentException("Pole daty końcowej nie może być puste");
        if(sprint.getName()==null)
            throw new IllegalArgumentException("Pole nazwy nie może być puste");
        if(sprint.getStatus()==null)
            throw new IllegalArgumentException("Pole statusu nie może być puste");
        if(sprint.getBeginDate().isAfter(sprint.getEndDate()))
            throw new IllegalArgumentException("Data początku musi być przed data końca");

        return sprintRepository.save(sprint);
    }



    public Set<SprintDto> getSprintsBetweenDates(LocalDate start, LocalDate stop){
        if(start.isAfter(stop))
            throw new IllegalArgumentException("Data początku musi być przed data końca");
        Optional<Set<Sprint>> optional= sprintRepository
                .findByBeginDateGreaterThanEqualAndEndDateLessThanEqual(start,stop);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("Nie znaleziono sprintów pomiędzy datami("+start+"-"+stop+")",0);
        return sprintMapper.mapEntityToDtoIgnoreAllExceptNameDatesStatus(optional.get());
    }

    public Long countStoryPointsBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<Long> optional= sprintRepository.countStoryPointsBySprintId(id);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("Sprint o podanym id nie istnieje lub nie ma przypisanych user stories",0);
        return optional.get();
    }

    @Transactional
    public Sprint saveSprintAndUserStories(Sprint sprint,Set<UserStory> userStories){
        Sprint s=saveSprint(sprint);
        userStories.forEach(x -> userStoryRepository.save(x));
        return s;
    }

    public Set<SprintDto> findAllWithOrWithoutUserStories(Boolean tasks){
        if(tasks){
            return sprintMapper.mapEntityIterableUserStoryOnlyNamePointsToDtoSet(sprintRepository.findAllFetchUserStories());
        }else{
            return sprintMapper.mapEntityToDtoWithoutConstraints(sprintRepository.findAll());
        }

    }

    @Transactional
    public void updateSprintStatus(Long id, SprintStatus status){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<Sprint> optional= sprintRepository.findById(id);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("Sprint o podanym id nie istnieje",0);
        optional.get().setStatus(status);



    }


}
