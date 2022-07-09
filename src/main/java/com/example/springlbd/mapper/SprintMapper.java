package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring",uses = {
        UserStoryMapper.class
})
public interface SprintMapper {
    @Named("baseSprintToDto")
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

    @Named("SprintSetToDtoSetWithOrWithoutUserStories")
    default Set<SprintDto> mapEntityToDtoWithWithoutUserStories(Boolean tasks, Iterable<Sprint> iterable){
        Set<SprintDto> sprintDtos=new HashSet<>();
        if(tasks!=null && tasks){
            iterable.forEach(i -> {
                SprintDto sprintDto = new SprintDto();
                sprintDto.setId(i.getId());
                sprintDto.setName(i.getName());
                sprintDto.setBeginDate(i.getBeginDate());
                sprintDto.setEndDate(i.getEndDate());
                sprintDto.setGoalDescription(i.getGoalDescription());
                sprintDto.setSprintStatus(i.getStatus());
                HashSet<UserStoryDto> userStoryDtos= new HashSet<>();
                i.getUserStories().forEach(j -> {
                    UserStoryDto userStoryDto = new UserStoryDto();
                    userStoryDto.setName(j.getName());
                    userStoryDto.setStoryPoints(j.getStoryPoints());
                    userStoryDtos.add(userStoryDto);
                });
                sprintDto.setUserStories(userStoryDtos);
                sprintDtos.add(sprintDto);
            });
        }else{
            iterable.forEach(i -> {
                SprintDto sprintDto = new SprintDto();
                sprintDto.setId(i.getId());
                sprintDto.setName(i.getName());
                sprintDto.setBeginDate(i.getBeginDate());
                sprintDto.setEndDate(i.getEndDate());
                sprintDto.setGoalDescription(i.getGoalDescription());
                sprintDto.setSprintStatus(i.getStatus());
                sprintDtos.add(sprintDto);
            });
        }
        return sprintDtos;
    }


}
