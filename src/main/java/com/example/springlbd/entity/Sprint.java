package com.example.springlbd.entity;

import com.example.springlbd.entity.enums.SprintStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "SPRINT")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "BEGIN_DATE")
    private LocalDate beginDate;
    @Column(name = "END_DATE")
    private LocalDate endDate;
    @Column(name = "GOAL_DESCRIPTION")
    private String goalDescription;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private SprintStatus sprintStatus;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    @JoinTable(
            name = "USER_STORY_SPRINT",
            joinColumns = {
                    @JoinColumn(
                            name = "SPRINT_ID",
                            referencedColumnName = "ID",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "USER_STORY_ID",
                            referencedColumnName = "ID",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private Set<UserStory> userStories;

    public Sprint(Long id, String name, LocalDate beginDate, LocalDate endDate, String goalDescription, SprintStatus sprintStatus, Set<UserStory> userStories) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.goalDescription = goalDescription;
        this.sprintStatus = sprintStatus;
        this.userStories = userStories;
    }

    public Sprint(String name, LocalDate beginDate, LocalDate endDate, String goalDescription, SprintStatus sprintStatus, Set<UserStory> userStories) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.goalDescription = goalDescription;
        this.sprintStatus = sprintStatus;
        this.userStories = userStories;
    }

    public Sprint() {
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

    public void setBeginDate(LocalDate startDate) {
        this.beginDate = startDate;
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

    public SprintStatus getStatus() {
        return sprintStatus;
    }

    public void setStatus(SprintStatus sprintStatus) {
        this.sprintStatus = sprintStatus;
    }

    public Set<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(Set<UserStory> userStories) {
        this.userStories = userStories;
    }
}

