package com.example.springlbd.controller;

import com.example.springlbd.dto.SprintDto.SprintDto;
import com.example.springlbd.services.SprintService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/sprint")
public class SprintController {

    SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping
    public Set<SprintDto> getSprints(@RequestParam("tasks") Boolean tasks){
         return sprintService.findAllWithOrWithoutUserStories(tasks);
    }
    @GetMapping("/points")
    public Long countStoryPointsBySprintId(@RequestParam("id") Long id){
        return sprintService.countStoryPointsBySprintId(id);
    }

}
