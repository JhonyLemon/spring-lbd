package com.example.springlbd.controller;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.services.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/userstory")
public class UserStoryController {

    UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @PostMapping(value = "/{id}")
    public UserStoryDto addUserStoryToSprint(@PathVariable Long id,@RequestBody UserStoryDto userStoryDto){
        return userStoryService.addUserStoryToSprint(id,userStoryDto);
    }

    @GetMapping
    public Set<UserStoryDto> getUserStoriesBySprintId(@RequestParam("id") Long id){
        return userStoryService.getUserStoriesBySprintId(id);
    }

}
