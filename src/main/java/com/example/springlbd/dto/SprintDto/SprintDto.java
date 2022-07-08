package com.example.springlbd.dto.SprintDto;

import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.SprintStatus;

import java.time.LocalDate;
import java.util.Set;

public class SprintDto {

    private Long id;
    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String goalDescription;
    private SprintStatus sprintStatus;

    private Set<UserStoryDto> userStories;

    public SprintDto(Long id, String name, LocalDate beginDate, LocalDate endDate, String goalDescription, SprintStatus sprintStatus, Set<UserStoryDto> userStoriesDto) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.goalDescription = goalDescription;
        this.sprintStatus = sprintStatus;
        this.userStories = userStoriesDto;
    }

    public SprintDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public SprintStatus getSprintStatus() {
        return sprintStatus;
    }

    public void setSprintStatus(SprintStatus sprintStatus) {
        this.sprintStatus = sprintStatus;
    }

    public Set<UserStoryDto> getUserStories() {
        return userStories;
    }

    public void setUserStories(Set<UserStoryDto> userStories) {
        this.userStories = userStories;
    }
}
