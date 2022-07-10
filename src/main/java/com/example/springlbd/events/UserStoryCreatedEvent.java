package com.example.springlbd.events;

import com.example.springlbd.entity.UserStory;

public class UserStoryCreatedEvent {
    private Long id;

    public Long getId() {
        return id;
    }

    public UserStoryCreatedEvent(Long id) {
        this.id = id;
    }
}
