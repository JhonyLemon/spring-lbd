package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Attachment;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-10T08:34:07+0200",
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

    @Override
    public SprintDto mapEntityToDtoIgnoreAllExceptNameDatesStatus(Sprint source) {
        if ( source == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setName( source.getName() );
        sprintDto.setBeginDate( source.getBeginDate() );
        sprintDto.setEndDate( source.getEndDate() );

        return sprintDto;
    }

    @Override
    public Set<SprintDto> mapEntityToDtoIgnoreAllExceptNameDatesStatus(Set<Sprint> source) {
        if ( source == null ) {
            return null;
        }

        Set<SprintDto> set = new LinkedHashSet<SprintDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Sprint sprint : source ) {
            set.add( mapEntityToDtoIgnoreAllExceptNameDatesStatus( sprint ) );
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

    protected Byte[] byteArrayToByteArray(byte[] byteArray) {
        if ( byteArray == null ) {
            return null;
        }

        Byte[] byteTmp = new Byte[byteArray.length];
        int i = 0;
        for ( byte byte1 : byteArray ) {
            byteTmp[i] = byte1;
            i++;
        }

        return byteTmp;
    }

    protected AttachmentsDto attachmentToAttachmentsDto(Attachment attachment) {
        if ( attachment == null ) {
            return null;
        }

        AttachmentsDto attachmentsDto = new AttachmentsDto();

        attachmentsDto.setId( attachment.getId() );
        attachmentsDto.setAttachment( byteArrayToByteArray( attachment.getAttachment() ) );
        attachmentsDto.setUserStory( attachment.getUserStory() );
        attachmentsDto.setName( attachment.getName() );

        return attachmentsDto;
    }

    protected Set<AttachmentsDto> attachmentSetToAttachmentsDtoSet(Set<Attachment> set) {
        if ( set == null ) {
            return null;
        }

        Set<AttachmentsDto> set1 = new LinkedHashSet<AttachmentsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Attachment attachment : set ) {
            set1.add( attachmentToAttachmentsDto( attachment ) );
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
        userStoryDto.setAttachments( attachmentSetToAttachmentsDtoSet( userStory.getAttachments() ) );

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

    protected byte[] byteArrayTobyteArray(Byte[] byteArray) {
        if ( byteArray == null ) {
            return null;
        }

        byte[] byteTmp = new byte[byteArray.length];
        int i = 0;
        for ( Byte byte1 : byteArray ) {
            byteTmp[i] = byte1;
            i++;
        }

        return byteTmp;
    }

    protected Attachment attachmentsDtoToAttachment(AttachmentsDto attachmentsDto) {
        if ( attachmentsDto == null ) {
            return null;
        }

        Attachment attachment = new Attachment();

        attachment.setId( attachmentsDto.getId() );
        attachment.setAttachment( byteArrayTobyteArray( attachmentsDto.getAttachment() ) );
        attachment.setUserStory( attachmentsDto.getUserStory() );
        attachment.setName( attachmentsDto.getName() );

        return attachment;
    }

    protected Set<Attachment> attachmentsDtoSetToAttachmentSet(Set<AttachmentsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Attachment> set1 = new LinkedHashSet<Attachment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AttachmentsDto attachmentsDto : set ) {
            set1.add( attachmentsDtoToAttachment( attachmentsDto ) );
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
        userStory.setAttachments( attachmentsDtoSetToAttachmentSet( userStoryDto.getAttachments() ) );
        userStory.setUserStoryStatus( userStoryDto.getUserStoryStatus() );

        return userStory;
    }
}
