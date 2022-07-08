package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto.SprintDto;
import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import org.mapstruct.Mapper;


import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SprintSetMapper {
    Set<SprintDto> mapEntityToDto(Set<Sprint> source);
    Set<Sprint> mapDtoToEntity(Set<SprintDto> destination);

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
