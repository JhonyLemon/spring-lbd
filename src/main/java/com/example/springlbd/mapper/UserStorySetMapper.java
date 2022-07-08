package com.example.springlbd.mapper;

import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserStorySetMapper {
    Set<UserStoryDto> mapEntityToDto(Set<UserStory> source);
    Set<UserStory> mapDtoToEntity(Set<UserStoryDto> destination);
}
