package com.example.springlbd.dto;

import com.example.springlbd.entity.UserStory;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttachmentsDto {

    private Byte[] attachment;
    private String name;
    private UserStory userStory;

}
