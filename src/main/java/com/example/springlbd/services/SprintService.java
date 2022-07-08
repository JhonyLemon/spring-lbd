package com.example.springlbd.services;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    private static final Logger LOG = LoggerFactory.getLogger(SprintService.class);
    private SprintRepository sprintRepository;

    private UserStoryRepository userStoryRepository;

    public SprintService(SprintRepository sprintRepository,UserStoryRepository userStoryRepository) {
        this.sprintRepository = sprintRepository;
        this.userStoryRepository=userStoryRepository;
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

    public List<UserStory> getUserStories(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<List<UserStory>> optional= sprintRepository.findUserStoriesById(id);
        return optional.get();
    }

    public List<Sprint> getSprintsBetweenDates(LocalDate start, LocalDate stop){
        if(start.isAfter(stop))
            throw new IllegalArgumentException("Data początku musi być przed data końca");
        Optional<List<Sprint>> optional= sprintRepository
                .findByBeginDateGreaterThanEqualAndEndDateLessThanEqual(start,stop);
        return optional.get();
    }

    public Long countStoryPointsBySprintId(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<Long> optional= sprintRepository.countStoryPointsBySprintId(id);
        return optional.get();
    }

    @Transactional
    public Sprint saveSprintAndUserStories(Sprint sprint,List<UserStory> userStories){
        LOG.info("Starting transaction");
        Sprint s=saveSprint(sprint);
        userStories.forEach(x -> userStoryRepository.save(x));
        return s;
    }
}
