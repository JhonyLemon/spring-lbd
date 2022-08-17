package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.entity.Sprint;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",uses = {
            UserStoryMapper.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SprintMapper {

    @Mapping(target = "userStories",ignore = true)
    @Named("SprintToSprintDtoWithoutConstraints")
    SprintDto SprintToSprintDtoWithoutConstraints(Sprint source);

    @Mapping(target = "goalDescription",ignore = true)
    @InheritConfiguration(name = "SprintToSprintDtoWithoutConstraints")
    @Named("SprintToSprintDtoIgnoreAllExceptNameDatesStatus")
    SprintDto SprintToSprintDtoIgnoreAllExceptNameDatesStatus(Sprint source);
    @IterableMapping(qualifiedByName = "SprintToSprintDtoIgnoreAllExceptNameDatesStatus")
    @Named("SprintListToSprintDtoListIgnoreAllExceptNameDatesStatus")
    List<SprintDto> SprintListToSprintDtoListIgnoreAllExceptNameDatesStatus(List<Sprint> source);

    @Named("SprintToSprintDtoUserStoryOnlyNamePointsToSprintDto")
    @Mappings(value = {
            @Mapping(target = "userStories",
                    source = "userStories",
                    qualifiedByName = "UserStoryListToUserStoryDtoListIgnoreAllExceptNamePoints"
            )
    })
    SprintDto SprintToSprintDtoUserStoryOnlyNamePointsToSprintDto(Sprint source);


    @IterableMapping(qualifiedByName = "SprintToSprintDtoUserStoryOnlyNamePointsToSprintDto")
    @Named("SprintIterableToSprintDtoListUserStoryOnlyNamePointsToSprintDto")
    List<SprintDto> SprintIterableToSprintDtoListUserStoryOnlyNamePointsToSprintDto(Iterable<Sprint> source);

    @IterableMapping(qualifiedByName = "SprintToSprintDtoWithoutConstraints")
    @Named("SprintIterableToSprintDtoListWithoutConstraints")
    List<SprintDto> SprintIterableToSprintDtoListWithoutConstraints(Iterable<Sprint> source);


}
