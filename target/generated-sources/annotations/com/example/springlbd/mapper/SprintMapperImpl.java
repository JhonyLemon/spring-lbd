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
    date = "2022-07-09T10:09:29+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class SprintMapperImpl implements SprintMapper {

    @Override
    public SprintDto mapEntityToDto(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setId( source.getId() );
        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );
        sprintDto.setGoalDescription( source.getGoalDescription() );
        sprintDto.setUserStories( userStorySetToUserStoryDtoSet( source.getUserStories() ) );

        return sprintDto;
    }

    @Override
    public Sprint mapDtoToEntity(SprintDto destination) {
        if ( destination == null ) {
            return null;
        }

        Sprint sprint = new Sprint();

        sprint.setId( destination.getId() );
        sprint.setName( destination.getName() );
        sprint.setBeginDate( destination.getBeginDate() );
        sprint.setEndDate( destination.getEndDate() );
        sprint.setGoalDescription( destination.getGoalDescription() );
        sprint.setUserStories( userStoryDtoSetToUserStorySet( destination.getUserStories() ) );

        return sprint;
    }

    protected Set<SprintDto> sprintSetToSprintDtoSet(Set<Sprint> set) {
        if ( set == null ) {
            return null;
        }

        Set<SprintDto> set1 = new LinkedHashSet<SprintDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : set ) {
            set1.add( mapEntityToDto( sprint ) );
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

    protected Set<Sprint> sprintDtoSetToSprintSet(Set<SprintDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Sprint> set1 = new LinkedHashSet<Sprint>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SprintDto sprintDto : set ) {
            set1.add( mapDtoToEntity( sprintDto ) );
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
}
