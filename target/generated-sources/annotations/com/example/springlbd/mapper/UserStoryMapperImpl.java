package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto.SprintDto;
import com.example.springlbd.dto.UserStoryDto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T10:10:19+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class UserStoryMapperImpl implements UserStoryMapper {

    @Override
    public UserStoryDto mapEntityToDto(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setId( source.getId() );
        userStoryDto.setName( source.getName() );
        userStoryDto.setDescription( source.getDescription() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );

        return userStoryDto;
    }

    @Override
    public UserStory mapDtoToEntity(UserStoryDto destination) {
        if ( destination == null ) {
            return null;
        }

        UserStory userStory = new UserStory();

        userStory.setId( destination.getId() );
        userStory.setName( destination.getName() );
        userStory.setDescription( destination.getDescription() );
        userStory.setStoryPoints( destination.getStoryPoints() );
        userStory.setSprints( sprintDtoSetToSprintSet( destination.getSprints() ) );

        return userStory;
    }

    protected Set<UserStory> userStoryDtoSetToUserStorySet(Set<UserStoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<UserStory> set1 = new LinkedHashSet<UserStory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserStoryDto userStoryDto : set ) {
            set1.add( mapDtoToEntity( userStoryDto ) );
        }

        return set1;
    }

    protected Sprint sprintDtoToSprint(SprintDto sprintDto) {
        if ( sprintDto == null ) {
            return null;
        }

        Sprint sprint = new Sprint();

        sprint.setId( sprintDto.getId() );
        sprint.setName( sprintDto.getName() );
        sprint.setBeginDate( sprintDto.getBeginDate() );
        sprint.setEndDate( sprintDto.getEndDate() );
        sprint.setGoalDescription( sprintDto.getGoalDescription() );
        sprint.setUserStories( userStoryDtoSetToUserStorySet( sprintDto.getUserStories() ) );

        return sprint;
    }

    protected Set<Sprint> sprintDtoSetToSprintSet(Set<SprintDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Sprint> set1 = new LinkedHashSet<Sprint>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SprintDto sprintDto : set ) {
            set1.add( sprintDtoToSprint( sprintDto ) );
        }

        return set1;
    }
}
