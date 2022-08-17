package com.example.springlbd.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ATTACHMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ATTACHMENT")
    @Lob
    private byte[] attachment;
    @Column(name = "FILE_NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name="USER_STORY_ID")
    private UserStory userStory;
}
