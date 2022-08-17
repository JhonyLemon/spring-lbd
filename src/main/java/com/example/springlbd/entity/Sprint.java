package com.example.springlbd.entity;

import com.example.springlbd.entity.enums.SprintStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "SPRINT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
    private List<UserStory> userStories =new ArrayList<>();

}

