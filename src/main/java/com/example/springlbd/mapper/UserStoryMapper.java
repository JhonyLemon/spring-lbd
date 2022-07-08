package com.example.springlbd.mapper;


import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserStoryMapper {
    UserStoryDto mapEntityToDto(UserStory source);
    UserStory mapDtoToEntity(UserStoryDto destination);
}
