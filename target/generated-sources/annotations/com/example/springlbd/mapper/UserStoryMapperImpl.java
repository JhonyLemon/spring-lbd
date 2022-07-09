package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T22:24:08+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class UserStoryMapperImpl implements UserStoryMapper {

    @Autowired
    private AttachmentsMapper attachmentsMapper;

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
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );
        userStoryDto.setSprints( sprintSetToSprintDtoSet( source.getSprints() ) );
        userStoryDto.setAttachments( attachmentsMapper.mapEntityToDto( source.getAttachments() ) );

        return userStoryDto;
    }

    @Override
    public Set<UserStoryDto> mapEntitySetToDtoSet(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( mapEntityToDto( userStory ) );
        }

        return set;
    }

    @Override
    public UserStoryDto mapEntityToDtoWithoutConstraints(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setId( source.getId() );
        userStoryDto.setName( source.getName() );
        userStoryDto.setDescription( source.getDescription() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );

        return userStoryDto;
    }

    @Override
    public Set<UserStoryDto> mapUserStorySetToDtoSetWithoutConstraints(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( mapEntityToDtoWithoutConstraints( userStory ) );
        }

        return set;
    }

    @Override
    public List<UserStoryDto> mapUserStoryListToDtoListWithoutConstraints(List<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        List<UserStoryDto> list = new ArrayList<UserStoryDto>( source.size() );
        for ( UserStory userStory : source ) {
            list.add( mapEntityToDtoWithoutConstraints( userStory ) );
        }

        return list;
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
        userStory.setAttachments( attachmentsMapper.mapDtoToEntity( destination.getAttachments() ) );
        userStory.setUserStoryStatus( destination.getUserStoryStatus() );

        return userStory;
    }

    @Override
    public Set<UserStory> mapDtoSetToEntitySet(Set<UserStoryDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<UserStory> set = new LinkedHashSet<UserStory>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( UserStoryDto userStoryDto : destination ) {
            set.add( mapDtoToEntity( userStoryDto ) );
        }

        return set;
    }

    @Override
    public UserStoryDto mapEntityToDtoIgnoreAttachmentsAndDescription(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setId( source.getId() );
        userStoryDto.setName( source.getName() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );

        return userStoryDto;
    }

    @Override
    public Set<UserStoryDto> mapEntityToDtoIgnoreAttachmentsAndDescription(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( mapEntityToDtoIgnoreAttachmentsAndDescription( userStory ) );
        }

        return set;
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
        userStoryDto.setUserStoryStatus( userStory.getUserStoryStatus() );
        userStoryDto.setSprints( sprintSetToSprintDtoSet( userStory.getSprints() ) );
        userStoryDto.setAttachments( attachmentsMapper.mapEntityToDto( userStory.getAttachments() ) );

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
        userStory.setAttachments( attachmentsMapper.mapDtoToEntity( userStoryDto.getAttachments() ) );
        userStory.setUserStoryStatus( userStoryDto.getUserStoryStatus() );

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
