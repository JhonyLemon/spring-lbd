package com.example.springlbd.dto;

import com.example.springlbd.entity.enums.UserStoryStatus;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserStoryDto {

    private String name;

    private String description;

    private Long storyPoints;

    private UserStoryStatus userStoryStatus;

    private List<AttachmentsDto> attachments;

    private List<SprintDto> sprints;

}
