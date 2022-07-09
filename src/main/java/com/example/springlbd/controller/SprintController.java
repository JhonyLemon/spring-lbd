package com.example.springlbd.controller;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.services.SprintService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping(value = "/sprint")
public class SprintController {

    private SprintService sprintService;

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

    @PutMapping("/update/{id}/{status}")
    public void updateStatus(
            @PathVariable("id") Long id,
            @PathVariable("status") SprintStatus status){

        sprintService.updateSprintStatus(id,status);

    }

    @GetMapping("/between")
    public Set<SprintDto> getSprintsBetweenDates(
            @RequestParam("begin_date") LocalDate beginDate,
            @RequestParam("end_date") LocalDate endDate){
        return sprintService.getSprintsBetweenDates(beginDate,endDate);
    }


}
