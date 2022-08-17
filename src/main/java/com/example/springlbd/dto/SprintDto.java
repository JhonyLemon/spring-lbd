package com.example.springlbd.dto;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.enums.SprintStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SprintDto {

    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String goalDescription;
    private SprintStatus sprintStatus;

    private List<UserStoryDto> userStories;

}
