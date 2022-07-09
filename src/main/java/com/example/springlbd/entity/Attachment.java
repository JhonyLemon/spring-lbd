package com.example.springlbd.entity;

import javax.persistence.*;

@Entity
@Table(name = "ATTACHMENT")
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
    @JoinColumn(name="USER_STORY_ID", nullable=false)
    private UserStory userStory;

    public Attachment(Long id, byte[] attachment, String name, UserStory userStory) {
        this.id = id;
        this.attachment = attachment;
        this.name = name;
        this.userStory = userStory;
    }

    public Attachment(byte[] attachment, String name, UserStory userStory) {
        this.attachment = attachment;
        this.name = name;
        this.userStory = userStory;
    }

    public Attachment() {
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
