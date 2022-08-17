package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.entity.Sprint;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T16:27:49+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class SprintMapperImpl implements SprintMapper {

    @Autowired
    private UserStoryMapper userStoryMapper;

    @Override
    public SprintDto SprintToSprintDtoWithoutConstraints(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );
        sprintDto.setGoalDescription( source.getGoalDescription() );
        sprintDto.setSprintStatus( source.getSprintStatus() );

        return sprintDto;
    }

    @Override
    public SprintDto SprintToSprintDtoIgnoreAllExceptNameDatesStatus(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );
        sprintDto.setSprintStatus( source.getSprintStatus() );

        return sprintDto;
    }

    @Override
    public List<SprintDto> SprintListToSprintDtoListIgnoreAllExceptNameDatesStatus(List<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        List<SprintDto> list = new ArrayList<SprintDto>( source.size() );
        for ( Sprint sprint : source ) {
            list.add( SprintToSprintDtoIgnoreAllExceptNameDatesStatus( sprint ) );
        }

        return list;
    }

    @Override
    public SprintDto SprintToSprintDtoUserStoryOnlyNamePointsToSprintDto(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setUserStories( userStoryMapper.UserStoryListToUserStoryDtoListIgnoreAllExceptNamePoints( source.getUserStories() ) );
        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );
        sprintDto.setGoalDescription( source.getGoalDescription() );
        sprintDto.setSprintStatus( source.getSprintStatus() );

        return sprintDto;
    }

    @Override
    public List<SprintDto> SprintIterableToSprintDtoListUserStoryOnlyNamePointsToSprintDto(Iterable<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        List<SprintDto> list = new ArrayList<SprintDto>();
        for ( Sprint sprint : source ) {
            list.add( SprintToSprintDtoUserStoryOnlyNamePointsToSprintDto( sprint ) );
        }

        return list;
    }

    @Override
    public List<SprintDto> SprintIterableToSprintDtoListWithoutConstraints(Iterable<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        List<SprintDto> list = new ArrayList<SprintDto>();
        for ( Sprint sprint : source ) {
            list.add( SprintToSprintDtoWithoutConstraints( sprint ) );
        }

        return list;
    }
}
