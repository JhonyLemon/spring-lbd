package com.example.springlbd.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAndRolesDto {

    private String name;
    private List<String> roles;

}
