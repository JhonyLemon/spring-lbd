package com.example.springlbd.mapper;


import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

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

    @Mapping(target = "sprints",ignore = true)
    @Mapping(target = "description",ignore = true)
    @Mapping(target = "attachments",ignore = true)
    @Named("ignoreDescriptionUserStoryToDto")
    UserStoryDto mapEntityToDtoIgnoreAttachmentsAndDescription(UserStory source);
    @IterableMapping(qualifiedByName = "ignoreDescriptionUserStoryToDto")
    @Named("ignoreDescriptionUserStorySetToDtoSet")
    Set<UserStoryDto> mapEntityToDtoIgnoreAttachmentsAndDescription(Set<UserStory> source);


}
