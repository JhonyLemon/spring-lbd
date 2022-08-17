package com.example.springlbd.events;

import com.example.springlbd.entity.UserStory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserStoryCreatedEvent {
    private final UserStory userStory;


}
