package com.example.springlbd.controller;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.services.SprintService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/sprint")
@AllArgsConstructor
public class SprintController {

    private final SprintService sprintService;


    @GetMapping
    public List<SprintDto> getSprints(@RequestParam("tasks") Boolean tasks){
         return sprintService.findAllWithOrWithoutUserStories(tasks);
    }

    @PostMapping(value = "/{id}")
    public void addUserStoryToSprint(@PathVariable Long id,@RequestBody UserStoryDto userStoryDto){
        sprintService.addUserStoryToSprint(id,userStoryDto);
    }

    @GetMapping("/points")
    public Long countStoryPointsBySprintId(@RequestParam("id") Long id){
        return sprintService.countStoryPointsBySprintId(id);
    }

    @GetMapping("/{id}")
    public List<UserStoryDto> getUserStoriesBySprintId(@PathVariable Long id){
        return sprintService.getUserStoriesBySprintId(id);
    }

    @PutMapping("/update/{id}/{status}")
    public void updateStatus(
            @PathVariable("id") Long id,
            @PathVariable("status") SprintStatus status){

        sprintService.updateSprintStatus(id,status);

    }

    @GetMapping("/between")
    public List<SprintDto> getSprintsBetweenDates(
            @RequestParam("begin_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
            @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return sprintService.getSprintsBetweenDates(beginDate,endDate);
    }


}
