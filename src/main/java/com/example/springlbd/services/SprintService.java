package com.example.springlbd.services;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SprintService {

    private static final Logger LOG = LoggerFactory.getLogger(SprintService.class);
    private final SprintRepository sprintRepository;

    private final UserStoryRepository userStoryRepository;


    @Transactional
    public Sprint saveSprint(Sprint sprint){
        if(sprint.getBeginDate()==null)
            throw new IllegalArgumentException("Pole daty początkowej nie może być puste");
        if(sprint.getEndDate()==null)
            throw new IllegalArgumentException("Pole daty końcowej nie może być puste");
        if(sprint.getName()==null)
            throw new IllegalArgumentException("Pole nazwy nie może być puste");
        if(sprint.getSprintStatus()==null)
            throw new IllegalArgumentException("Pole statusu nie może być puste");
        if(sprint.getBeginDate().isAfter(sprint.getEndDate()))
            throw new IllegalArgumentException("Data początku musi być przed data końca");

        return sprintRepository.save(sprint);
    }

    public List<UserStory> getUserStories(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        return sprintRepository
                .findUserStoriesById(id)
                .orElseThrow(()->new EntityNotFoundException("Sprint nie istnieje lub nie posiada user stories"));
    }

    public List<Sprint> getSprintsBetweenDates(LocalDate start, LocalDate stop){
        if(start.isAfter(stop))
            throw new IllegalArgumentException("Data początku musi być przed data końca");
        return sprintRepository
                .findByBeginDateGreaterThanEqualAndEndDateLessThanEqual(start,stop)
                .orElseThrow(()->new EntityNotFoundException("Sprint w podanym zakresie dat nie istnieją"));
    }

    public Long countStoryPointsBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        return sprintRepository.countStoryPointsBySprintId(id)
                .orElseThrow(()-> new EntityNotFoundException("Nie można zliczyć punktów"));
    }

    @Transactional
    public Sprint saveSprintAndUserStories(Sprint sprint,List<UserStory> userStories){
        LOG.info("Starting transaction");
        Sprint s=saveSprint(sprint);
        userStories.forEach(x -> userStoryRepository.save(x));
        return s;
    }


}
