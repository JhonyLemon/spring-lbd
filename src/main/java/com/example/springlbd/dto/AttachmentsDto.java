package com.example.springlbd.dto;

import com.example.springlbd.entity.UserStory;

import java.util.Arrays;

public class AttachmentsDto {

    private Long id;
    private Byte[] attachment;
    private String name;

    private UserStory userStory;

    public AttachmentsDto(Long id, Byte[] attachment, String name, UserStory userStory) {
        this.id = id;
        this.attachment = attachment;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AttachmentsDto{" +
                "id=" + id +
                ", attachment=" + Arrays.toString(attachment) +
                ", name='" + name + '\'' +
                ", userStory=" + userStory +
                '}';
    }
}
