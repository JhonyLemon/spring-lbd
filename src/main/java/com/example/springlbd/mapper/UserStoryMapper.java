package com.example.springlbd.mapper;


import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserStoryMapper {
    @Mapping(target = "sprints",ignore = true)
    UserStoryDto mapEntityToDto(UserStory source);
    UserStory mapDtoToEntity(UserStoryDto destination);
}
