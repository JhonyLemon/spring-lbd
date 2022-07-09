package com.example.springlbd.controller;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.services.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/userstory")
public class UserStoryController {

    private UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @PostMapping(value = "/{id}")
    public UserStoryDto addUserStoryToSprint(@PathVariable Long id,@RequestBody UserStoryDto userStoryDto){
        return userStoryService.addUserStoryToSprint(id,userStoryDto);
    }

    @GetMapping("/BySprintId")
    public Set<UserStoryDto> getUserStoriesBySprintId(@RequestParam("id") Long id){
        return userStoryService.getUserStoriesBySprintId(id);
    }

    @GetMapping("/DescriptionById")
    public String getUserStoryDescriptionById(@RequestParam("id") Long id){
        return userStoryService.getUserStoryDescriptionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserStoryById(@PathVariable("id") Long id){
        userStoryService.deleteUserStoryById(id);
    }

    @GetMapping("/sortedByName")
    public List<UserStoryDto> getSortedByNamePage(@RequestParam("pageSize") Integer pageSize,
                                  @RequestParam("pageNumber") Integer pageNumber){
        return userStoryService.getSortedByNamePage(pageSize,pageNumber);
    }


}
