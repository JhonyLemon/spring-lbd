package com.example.springlbd.entity;

import com.example.springlbd.entity.enums.UserStoryStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "userStory",cascade = CascadeType.ALL)
    private List<Attachment> attachments = new ArrayList<>();

    @Column(name = "STORY_POINTS")
    private Long storyPoints;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private UserStoryStatus userStoryStatus;

    @ManyToMany(mappedBy = "userStories",cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    private List<Sprint> sprints = new ArrayList<>();

}
