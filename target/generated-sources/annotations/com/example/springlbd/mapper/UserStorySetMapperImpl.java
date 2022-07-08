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
    date = "2022-07-08T21:50:30+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class UserStorySetMapperImpl implements UserStorySetMapper {

    @Override
    public Set<UserStoryDto> mapEntityToDto(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( userStoryToUserStoryDto( userStory ) );
        }

        return set;
    }

    @Override
    public Set<UserStory> mapDtoToEntity(Set<UserStoryDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<UserStory> set = new LinkedHashSet<UserStory>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( UserStoryDto userStoryDto : destination ) {
            set.add( userStoryDtoToUserStory( userStoryDto ) );
        }

        return set;
    }

    protected SprintDto sprintToSprintDto(Sprint sprint) {
        if ( sprint == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setId( sprint.getId() );
        sprintDto.setName( sprint.getName() );
        sprintDto.setBeginDate( sprint.getBeginDate() );
        sprintDto.setEndDate( sprint.getEndDate() );
        sprintDto.setGoalDescription( sprint.getGoalDescription() );
        sprintDto.setUserStories( mapEntityToDto( sprint.getUserStories() ) );

        return sprintDto;
    }

    protected Set<SprintDto> sprintSetToSprintDtoSet(Set<Sprint> set) {
        if ( set == null ) {
            return null;
        }

        Set<SprintDto> set1 = new LinkedHashSet<SprintDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : set ) {
            set1.add( sprintToSprintDto( sprint ) );
        }

        return set1;
    }

    protected UserStoryDto userStoryToUserStoryDto(UserStory userStory) {
        if ( userStory == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setId( userStory.getId() );
        userStoryDto.setName( userStory.getName() );
        userStoryDto.setDescription( userStory.getDescription() );
        userStoryDto.setStoryPoints( userStory.getStoryPoints() );
        userStoryDto.setSprints( sprintSetToSprintDtoSet( userStory.getSprints() ) );

        return userStoryDto;
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
        sprint.setUserStories( mapDtoToEntity( sprintDto.getUserStories() ) );

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

    protected UserStory userStoryDtoToUserStory(UserStoryDto userStoryDto) {
        if ( userStoryDto == null ) {
            return null;
        }

        UserStory userStory = new UserStory();

        userStory.setId( userStoryDto.getId() );
        userStory.setName( userStoryDto.getName() );
        userStory.setDescription( userStoryDto.getDescription() );
        userStory.setStoryPoints( userStoryDto.getStoryPoints() );
        userStory.setSprints( sprintDtoSetToSprintSet( userStoryDto.getSprints() ) );

        return userStory;
    }
}
