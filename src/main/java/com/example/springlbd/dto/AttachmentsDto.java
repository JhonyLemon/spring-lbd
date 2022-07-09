package com.example.springlbd.dto;

import com.example.springlbd.entity.UserStory;

public class AttachmentsDto {

    private Long id;

    private Byte[] attachment;

    private UserStory userStory;

    public AttachmentsDto(Long id, Byte[] attachment, UserStory userStory) {
        this.id = id;
        this.attachment = attachment;
        this.userStory = userStory;
    }

    public AttachmentsDto() {
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
