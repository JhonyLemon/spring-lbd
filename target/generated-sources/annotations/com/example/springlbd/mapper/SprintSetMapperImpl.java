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
    date = "2022-07-08T21:51:16+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class SprintSetMapperImpl implements SprintSetMapper {

    @Override
    public Set<SprintDto> mapEntityToDto(Set<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        Set<SprintDto> set = new LinkedHashSet<SprintDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : source ) {
            set.add( sprintToSprintDto( sprint ) );
        }

        return set;
    }

    @Override
    public Set<Sprint> mapDtoToEntity(Set<SprintDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<Sprint> set = new LinkedHashSet<Sprint>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( SprintDto sprintDto : destination ) {
            set.add( sprintDtoToSprint( sprintDto ) );
        }

        return set;
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
        userStoryDto.setSprints( mapEntityToDto( userStory.getSprints() ) );

        return userStoryDto;
    }

    protected Set<UserStoryDto> userStorySetToUserStoryDtoSet(Set<UserStory> set) {
        if ( set == null ) {
            return null;
        }

        Set<UserStoryDto> set1 = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : set ) {
            set1.add( userStoryToUserStoryDto( userStory ) );
        }

        return set1;
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
        sprintDto.setUserStories( userStorySetToUserStoryDtoSet( sprint.getUserStories() ) );

        return sprintDto;
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
        userStory.setSprints( mapDtoToEntity( userStoryDto.getSprints() ) );

        return userStory;
    }

    protected Set<UserStory> userStoryDtoSetToUserStorySet(Set<UserStoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<UserStory> set1 = new LinkedHashSet<UserStory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserStoryDto userStoryDto : set ) {
            set1.add( userStoryDtoToUserStory( userStoryDto ) );
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
}
