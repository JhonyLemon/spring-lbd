package com.example.springlbd.dto;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.entity.enums.UserStoryStatus;
import org.modelmapper.ModelMapper;

import java.util.Set;


public class UserStoryDto {

    private Long id;

    private String name;

    private String description;

    private Long storyPoints;

    private UserStoryStatus userStoryStatus;

    private Set<Sprint> sprints;

    public UserStoryDto(Long id, String name, String description, Long storyPoints, UserStoryStatus userStoryStatus, Set<Sprint> sprints) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storyPoints = storyPoints;
        this.userStoryStatus = userStoryStatus;
        this.sprints = sprints;
    }

    public UserStoryDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Long storyPoints) {
        this.storyPoints = storyPoints;
    }

    public UserStoryStatus getUserStoryStatus() {
        return userStoryStatus;
    }

    public void setUserStoryStatus(UserStoryStatus userStoryStatus) {
        this.userStoryStatus = userStoryStatus;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public static UserStory mapToEntity(UserStoryDto userStoryDto){
        return new ModelMapper().map(userStoryDto,UserStory.class);
    }

    public static UserStoryDto mapToDto(UserStory userStory){
        return new ModelMapper().map(userStory,UserStoryDto.class);
    }

}
