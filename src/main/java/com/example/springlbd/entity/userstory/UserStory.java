package com.example.springlbd.entity.userstory;

import com.example.springlbd.entity.sprint.Sprint;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STORY_POINTS")
    private Long storyPoints;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "userStories")
    private Set<Sprint> sprints;

    public UserStory(Long id, String name, String description, Long storyPoints, Status status, Set<Sprint> sprints) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storyPoints = storyPoints;
        this.status = status;
        this.sprints = sprints;
    }

    public UserStory(String name, String description, Long storyPoints, Status status, Set<Sprint> sprints) {
        this.name = name;
        this.description = description;
        this.storyPoints = storyPoints;
        this.status = status;
        this.sprints = sprints;
    }

    public UserStory() {

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }
}
