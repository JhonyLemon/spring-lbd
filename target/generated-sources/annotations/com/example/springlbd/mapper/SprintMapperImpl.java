package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Attachments;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T16:30:30+0200",
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
    public Set<SprintDto> mapEntityToDto(Set<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        Set<SprintDto> set = new LinkedHashSet<SprintDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : source ) {
            set.add( mapEntityToDto( sprint ) );
        }

        return set;
    }

    @Override
    public SprintDto mapEntityToDtoWithoutConstraints(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setId( source.getId() );
        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );
        sprintDto.setGoalDescription( source.getGoalDescription() );

        return sprintDto;
    }

    @Override
    public Set<SprintDto> mapEntityToDtoWithoutConstraints(Set<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        Set<SprintDto> set = new LinkedHashSet<SprintDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : source ) {
            set.add( mapEntityToDtoWithoutConstraints( sprint ) );
        }

        return set;
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

    @Override
    public Set<Sprint> mapDtoToEntity(Set<SprintDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<Sprint> set = new LinkedHashSet<Sprint>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( SprintDto sprintDto : destination ) {
            set.add( mapDtoToEntity( sprintDto ) );
        }

        return set;
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

    protected AttachmentsDto attachmentsToAttachmentsDto(Attachments attachments) {
        if ( attachments == null ) {
            return null;
        }

        AttachmentsDto attachmentsDto = new AttachmentsDto();

        attachmentsDto.setId( attachments.getId() );
        Byte[] attachment = attachments.getAttachment();
        if ( attachment != null ) {
            attachmentsDto.setAttachment( Arrays.copyOf( attachment, attachment.length ) );
        }
        attachmentsDto.setUserStory( attachments.getUserStory() );

        return attachmentsDto;
    }

    protected Set<AttachmentsDto> attachmentsSetToAttachmentsDtoSet(Set<Attachments> set) {
        if ( set == null ) {
            return null;
        }

        Set<AttachmentsDto> set1 = new LinkedHashSet<AttachmentsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Attachments attachments : set ) {
            set1.add( attachmentsToAttachmentsDto( attachments ) );
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
        userStoryDto.setAttachments( attachmentsSetToAttachmentsDtoSet( userStory.getAttachments() ) );

        return userStoryDto;
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

    protected Attachments attachmentsDtoToAttachments(AttachmentsDto attachmentsDto) {
        if ( attachmentsDto == null ) {
            return null;
        }

        Attachments attachments = new Attachments();

        attachments.setId( attachmentsDto.getId() );
        Byte[] attachment = attachmentsDto.getAttachment();
        if ( attachment != null ) {
            attachments.setAttachment( Arrays.copyOf( attachment, attachment.length ) );
        }
        attachments.setUserStory( attachmentsDto.getUserStory() );

        return attachments;
    }

    protected Set<Attachments> attachmentsDtoSetToAttachmentsSet(Set<AttachmentsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Attachments> set1 = new LinkedHashSet<Attachments>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AttachmentsDto attachmentsDto : set ) {
            set1.add( attachmentsDtoToAttachments( attachmentsDto ) );
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
        userStory.setAttachments( attachmentsDtoSetToAttachmentsSet( userStoryDto.getAttachments() ) );
        userStory.setUserStoryStatus( userStoryDto.getUserStoryStatus() );

        return userStory;
    }
}
