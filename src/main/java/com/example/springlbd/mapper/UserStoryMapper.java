package com.example.springlbd.mapper;


import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.UserStory;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "spring",uses = {
            AttachmentsMapper.class,
            SprintMapper.class,
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserStoryMapper {

    @Named("UserStoryToUserStoryDto")
    UserStoryDto UserStoryToUserStoryDto(UserStory source);

    @IterableMapping(qualifiedByName = "UserStoryToUserStoryDto")
    @Named("UserStorySetToUserStoryDtoSet")
    Set<UserStoryDto> UserStorySetToUserStoryDtoSet(Set<UserStory> source);

    @Mapping(target = "attachments",ignore = true)
    @Mapping(target = "sprints",ignore = true)
    @Named("UserStoryToUserStoryDtoWithoutConstraints")
    UserStoryDto UserStoryToUserStoryDtoWithoutConstraints(UserStory source);
    @IterableMapping(qualifiedByName = "UserStoryToUserStoryDtoWithoutConstraints")
    @Named("UserStorySetToUserStoryDtoSetWithoutConstraints")
    Set<UserStoryDto> UserStorySetToUserStoryDtoSetWithoutConstraints(Set<UserStory> source);

    @IterableMapping(qualifiedByName = "UserStoryToUserStoryDtoWithoutConstraints")
    @Named("UserStoryListToUserStoryDtoListWithoutConstraints")
    List<UserStoryDto> UserStoryListToUserStoryDtoListWithoutConstraints(List<UserStory> source);

    @Named("UserStoryDtoToUserStory")
    UserStory UserStoryDtoToUserStory(UserStoryDto destination);

    @IterableMapping(qualifiedByName = "UserStoryDtoToUserStory")
    @Named("UserStoryDtoSetToUserStorySet")
    Set<UserStory> UserStoryDtoSetToUserStorySet(Set<UserStoryDto> destination);


    @Mapping(target = "description",ignore = true)
    @InheritConfiguration(name = "UserStoryToUserStoryDtoWithoutConstraints")
    @Named("UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription")
    UserStoryDto UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription(UserStory source);

    @IterableMapping(qualifiedByName = "UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription")
    @Named("UserStoryListToUserStoryDtoListIgnoreAttachmentsAndDescription")
    List<UserStoryDto> UserStoryListToUserStoryDtoListIgnoreAttachmentsAndDescription(List<UserStory> source);

    @Mapping(target = "userStoryStatus",ignore = true)
    @InheritConfiguration(name = "UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription")
    @Named("UserStoryToUserStoryDtoIgnoreAllExceptNamePoints")
    UserStoryDto UserStoryToUserStoryDtoIgnoreAllExceptNamePoints(UserStory source);

    @IterableMapping(qualifiedByName = "UserStoryToUserStoryDtoIgnoreAllExceptNamePoints")
    @Named("UserStoryListToUserStoryDtoListIgnoreAllExceptNamePoints")
    List<UserStoryDto> UserStoryListToUserStoryDtoListIgnoreAllExceptNamePoints(List<UserStory> source);


}
