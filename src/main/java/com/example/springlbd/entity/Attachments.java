package com.example.springlbd.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ATTACHMENTS")
public class Attachments {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ATTACHMENT")
    @Lob
    private Byte[] attachment;
    @ManyToOne
    @JoinColumn(name="USER_STORY_ID", nullable=false)
    private UserStory userStory;

    public Attachments(Long id, Byte[] attachment, UserStory userStory) {
        this.id = id;
        this.attachment = attachment;
        this.userStory = userStory;
    }

    public Attachments(Byte[] attachment, UserStory userStory) {
        this.attachment = attachment;
        this.userStory = userStory;
    }

    public Attachments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(Byte[] attachment) {
        this.attachment = attachment;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }
}
