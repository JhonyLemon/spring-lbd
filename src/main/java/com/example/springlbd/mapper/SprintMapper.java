package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;

import org.mapstruct.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring",uses = {
        UserStoryMapper.class
})
public interface SprintMapper {
    @Named("baseSprintToDto")
    @Mappings(value = {
            @Mapping(target = "userStories",
                    source = "userStories",
                    qualifiedByName = "baseUserStorySetToDtoSetWithoutConstraints"
            )
    })
    SprintDto mapEntityToDto(Sprint source);
    @IterableMapping(qualifiedByName = "baseSprintToDto")
    @Named("baseSprintSetToDtoSet")
    Set<SprintDto> mapEntityToDto(Set<Sprint> source);

    @Mapping(target = "userStories",ignore = true)
    @Named("baseSprintToDtoWithoutConstraints")
    SprintDto mapEntityToDtoWithoutConstraints(Sprint source);
    @IterableMapping(qualifiedByName = "baseSprintToDtoWithoutConstraints")
    @Named("baseSprintSetToDtoSetWithoutConstraints")
    Set<SprintDto> mapEntityToDtoWithoutConstraints(Set<Sprint> source);

    @Named("baseSprintDtoToEntity")
    Sprint mapDtoToEntity(SprintDto destination);
    @IterableMapping(qualifiedByName = "baseSprintDtoToEntity")
    @Named("baseSprintSetDtoSetToEntity")
    Set<Sprint> mapDtoToEntity(Set<SprintDto> destination);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "goalDescription",ignore = true)
    @InheritConfiguration(name = "mapEntityToDtoWithoutConstraints")
    @Named("ignoreAllExceptNameDatesStatusSprintToDto")
    SprintDto mapEntityToDtoIgnoreAllExceptNameDatesStatus(Sprint source);
    @IterableMapping(qualifiedByName = "ignoreAllExceptNameDatesStatusSprintToDto")
    @Named("ignoreAllExceptNameDatesStatusSprintSetToDtoSet")
    Set<SprintDto> mapEntityToDtoIgnoreAllExceptNameDatesStatus(Set<Sprint> source);

    @Named("EntityUserStoryOnlyNamePointsToDto")
    @Mappings(value = {
            @Mapping(target = "userStories",
                    source = "userStories",
                    qualifiedByName = "ignoreAllExceptNamePointsUserStorySetToDtoSet"
            )
    })
    SprintDto mapEntityUserStoryOnlyNamePointsToDto(Sprint source);


    @IterableMapping(qualifiedByName = "EntityUserStoryOnlyNamePointsToDto")
    @Named("EntityIterableUserStoryOnlyNamePointsToDtoSet")
    Set<SprintDto> mapEntityIterableUserStoryOnlyNamePointsToDtoSet(Iterable<Sprint> source);

    @IterableMapping(qualifiedByName = "baseSprintToDtoWithoutConstraints")
    @Named("baseSprintIterableToDtoSetWithoutConstraints")
    Set<SprintDto> mapEntityToDtoWithoutConstraints(Iterable<Sprint> source);


}
