package com.example.springlbd.mapper;


import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",uses = {
        AttachmentsMapper.class,
        SprintMapper.class
})
public interface UserStoryMapper {

    @Named("baseUserStoryToDto")
    UserStoryDto mapEntityToDto(UserStory source);

    @IterableMapping(qualifiedByName = "baseUserStoryToDto")
    @Named("baseUserStorySetToDtoSet")
    Set<UserStoryDto> mapEntitySetToDtoSet(Set<UserStory> source);

    @Mapping(target = "attachments",ignore = true)
    @Mapping(target = "sprints",ignore = true)
    @Named("baseUserStoryToDtoWithoutConstraints")
    UserStoryDto mapEntityToDtoWithoutConstraints(UserStory source);
    @IterableMapping(qualifiedByName = "baseUserStoryToDtoWithoutConstraints")
    @Named("baseUserStorySetToDtoSetWithoutConstraints")
    Set<UserStoryDto> mapUserStorySetToDtoSetWithoutConstraints(Set<UserStory> source);

    @IterableMapping(qualifiedByName = "baseUserStoryToDtoWithoutConstraints")
    @Named("baseUserStoryListToDtoListWithoutConstraints")
    List<UserStoryDto> mapUserStoryListToDtoListWithoutConstraints(List<UserStory> source);

    @Named("baseUserStoryDtoToEntity")
    UserStory mapDtoToEntity(UserStoryDto destination);

    @IterableMapping(qualifiedByName = "baseUserStoryDtoToEntity")
    @Named("baseUserStoryDtoSetToEntitySet")
    Set<UserStory> mapDtoSetToEntitySet(Set<UserStoryDto> destination);


    @Mapping(target = "description",ignore = true)
    @InheritConfiguration(name = "mapEntityToDtoWithoutConstraints")
    @Named("ignoreDescriptionUserStoryToDto")
    UserStoryDto mapEntityToDtoIgnoreAttachmentsAndDescription(UserStory source);

    @IterableMapping(qualifiedByName = "ignoreDescriptionUserStoryToDto")
    @Named("ignoreDescriptionUserStorySetToDtoSet")
    Set<UserStoryDto> mapEntityToDtoIgnoreAttachmentsAndDescription(Set<UserStory> source);

    @Mapping(target = "userStoryStatus",ignore = true)
    @Mapping(target = "id",ignore = true)
    @InheritConfiguration(name = "mapEntityToDtoIgnoreAttachmentsAndDescription")
    @Named("ignoreAllExceptNamePointsDescriptionUserStoryToDto")
    UserStoryDto mapEntityToDtoIgnoreAllExceptNamePoints(UserStory source);

    @IterableMapping(qualifiedByName = "ignoreAllExceptNamePointsDescriptionUserStoryToDto")
    @Named("ignoreAllExceptNamePointsUserStorySetToDtoSet")
    Set<UserStoryDto> mapEntityToDtoIgnoreAllExceptNamePoints(Set<UserStory> source);


}
