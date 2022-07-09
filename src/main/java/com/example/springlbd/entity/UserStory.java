package com.example.springlbd.entity;

import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.Sprint;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER_STORY")
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "userStory",cascade = CascadeType.PERSIST)
    private Set<Attachments> attachments;

    @Column(name = "STORY_POINTS")
    private Long storyPoints;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private UserStoryStatus userStoryStatus;

    @ManyToMany(mappedBy = "userStories",cascade = CascadeType.PERSIST)
    private Set<Sprint> sprints;


    public UserStory(Long id, String name, String description, Set<Attachments> attachments, Long storyPoints, UserStoryStatus userStoryStatus, Set<Sprint> sprints) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attachments = attachments;
        this.storyPoints = storyPoints;
        this.userStoryStatus = userStoryStatus;
        this.sprints = sprints;
    }

    public UserStory(String name, String description, Set<Attachments> attachments, Long storyPoints, UserStoryStatus userStoryStatus, Set<Sprint> sprints) {
        this.name = name;
        this.description = description;
        this.attachments = attachments;
        this.storyPoints = storyPoints;
        this.userStoryStatus = userStoryStatus;
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

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public Set<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachments> attachments) {
        this.attachments = attachments;
    }

    public UserStoryStatus getUserStoryStatus() {
        return userStoryStatus;
    }

    public void setUserStoryStatus(UserStoryStatus userStoryStatus) {
        this.userStoryStatus = userStoryStatus;
    }
}
