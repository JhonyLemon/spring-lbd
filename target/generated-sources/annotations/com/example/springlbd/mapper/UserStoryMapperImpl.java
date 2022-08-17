package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.dto.SprintDto;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Attachment;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T16:27:49+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class UserStoryMapperImpl implements UserStoryMapper {

    @Override
    public UserStoryDto UserStoryToUserStoryDto(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setName( source.getName() );
        userStoryDto.setDescription( source.getDescription() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );
        userStoryDto.setAttachments( attachmentListToAttachmentsDtoList( source.getAttachments() ) );
        userStoryDto.setSprints( sprintListToSprintDtoList( source.getSprints() ) );

        return userStoryDto;
    }

    @Override
    public Set<UserStoryDto> UserStorySetToUserStoryDtoSet(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( UserStoryToUserStoryDto( userStory ) );
        }

        return set;
    }

    @Override
    public UserStoryDto UserStoryToUserStoryDtoWithoutConstraints(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setName( source.getName() );
        userStoryDto.setDescription( source.getDescription() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );

        return userStoryDto;
    }

    @Override
    public Set<UserStoryDto> UserStorySetToUserStoryDtoSetWithoutConstraints(Set<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        Set<UserStoryDto> set = new LinkedHashSet<UserStoryDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( UserStory userStory : source ) {
            set.add( UserStoryToUserStoryDtoWithoutConstraints( userStory ) );
        }

        return set;
    }

    @Override
    public List<UserStoryDto> UserStoryListToUserStoryDtoListWithoutConstraints(List<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        List<UserStoryDto> list = new ArrayList<UserStoryDto>( source.size() );
        for ( UserStory userStory : source ) {
            list.add( UserStoryToUserStoryDtoWithoutConstraints( userStory ) );
        }

        return list;
    }

    @Override
    public UserStory UserStoryDtoToUserStory(UserStoryDto destination) {
        if ( destination == null ) {
            return null;
        }

        UserStory.UserStoryBuilder userStory = UserStory.builder();

        userStory.name( destination.getName() );
        userStory.description( destination.getDescription() );
        userStory.attachments( attachmentsDtoListToAttachmentList( destination.getAttachments() ) );
        userStory.storyPoints( destination.getStoryPoints() );
        userStory.userStoryStatus( destination.getUserStoryStatus() );
        userStory.sprints( sprintDtoListToSprintList( destination.getSprints() ) );

        return userStory.build();
    }

    @Override
    public Set<UserStory> UserStoryDtoSetToUserStorySet(Set<UserStoryDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<UserStory> set = new LinkedHashSet<UserStory>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( UserStoryDto userStoryDto : destination ) {
            set.add( UserStoryDtoToUserStory( userStoryDto ) );
        }

        return set;
    }

    @Override
    public UserStoryDto UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setName( source.getName() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );
        userStoryDto.setUserStoryStatus( source.getUserStoryStatus() );

        return userStoryDto;
    }

    @Override
    public List<UserStoryDto> UserStoryListToUserStoryDtoListIgnoreAttachmentsAndDescription(List<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        List<UserStoryDto> list = new ArrayList<UserStoryDto>( source.size() );
        for ( UserStory userStory : source ) {
            list.add( UserStoryToUserStoryDtoIgnoreAttachmentsAndDescription( userStory ) );
        }

        return list;
    }

    @Override
    public UserStoryDto UserStoryToUserStoryDtoIgnoreAllExceptNamePoints(UserStory source) {
        if ( source == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setName( source.getName() );
        userStoryDto.setStoryPoints( source.getStoryPoints() );

        return userStoryDto;
    }

    @Override
    public List<UserStoryDto> UserStoryListToUserStoryDtoListIgnoreAllExceptNamePoints(List<UserStory> source) {
        if ( source == null ) {
            return null;
        }

        List<UserStoryDto> list = new ArrayList<UserStoryDto>( source.size() );
        for ( UserStory userStory : source ) {
            list.add( UserStoryToUserStoryDtoIgnoreAllExceptNamePoints( userStory ) );
        }

        return list;
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

        attachmentsDto.setAttachment( byteArrayToByteArray( attachment.getAttachment() ) );
        attachmentsDto.setName( attachment.getName() );
        attachmentsDto.setUserStory( attachment.getUserStory() );

        return attachmentsDto;
    }

    protected List<AttachmentsDto> attachmentListToAttachmentsDtoList(List<Attachment> list) {
        if ( list == null ) {
            return null;
        }

        List<AttachmentsDto> list1 = new ArrayList<AttachmentsDto>( list.size() );
        for ( Attachment attachment : list ) {
            list1.add( attachmentToAttachmentsDto( attachment ) );
        }

        return list1;
    }

    protected List<SprintDto> sprintListToSprintDtoList(List<Sprint> list) {
        if ( list == null ) {
            return null;
        }

        List<SprintDto> list1 = new ArrayList<SprintDto>( list.size() );
        for ( Sprint sprint : list ) {
            list1.add( sprintToSprintDto( sprint ) );
        }

        return list1;
    }

    protected UserStoryDto userStoryToUserStoryDto(UserStory userStory) {
        if ( userStory == null ) {
            return null;
        }

        UserStoryDto userStoryDto = new UserStoryDto();

        userStoryDto.setName( userStory.getName() );
        userStoryDto.setDescription( userStory.getDescription() );
        userStoryDto.setStoryPoints( userStory.getStoryPoints() );
        userStoryDto.setUserStoryStatus( userStory.getUserStoryStatus() );
        userStoryDto.setAttachments( attachmentListToAttachmentsDtoList( userStory.getAttachments() ) );
        userStoryDto.setSprints( sprintListToSprintDtoList( userStory.getSprints() ) );

        return userStoryDto;
    }

    protected List<UserStoryDto> userStoryListToUserStoryDtoList(List<UserStory> list) {
        if ( list == null ) {
            return null;
        }

        List<UserStoryDto> list1 = new ArrayList<UserStoryDto>( list.size() );
        for ( UserStory userStory : list ) {
            list1.add( userStoryToUserStoryDto( userStory ) );
        }

        return list1;
    }

    protected SprintDto sprintToSprintDto(Sprint sprint) {
        if ( sprint == null ) {
            return null;
        }

        SprintDto sprintDto = new SprintDto();

        sprintDto.setName( sprint.getName() );
        sprintDto.setBeginDate( sprint.getBeginDate() );
        sprintDto.setEndDate( sprint.getEndDate() );
        sprintDto.setGoalDescription( sprint.getGoalDescription() );
        sprintDto.setSprintStatus( sprint.getSprintStatus() );
        sprintDto.setUserStories( userStoryListToUserStoryDtoList( sprint.getUserStories() ) );

        return sprintDto;
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

        Attachment.AttachmentBuilder attachment = Attachment.builder();

        attachment.attachment( byteArrayTobyteArray( attachmentsDto.getAttachment() ) );
        attachment.name( attachmentsDto.getName() );
        attachment.userStory( attachmentsDto.getUserStory() );

        return attachment.build();
    }

    protected List<Attachment> attachmentsDtoListToAttachmentList(List<AttachmentsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Attachment> list1 = new ArrayList<Attachment>( list.size() );
        for ( AttachmentsDto attachmentsDto : list ) {
            list1.add( attachmentsDtoToAttachment( attachmentsDto ) );
        }

        return list1;
    }

    protected List<Sprint> sprintDtoListToSprintList(List<SprintDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Sprint> list1 = new ArrayList<Sprint>( list.size() );
        for ( SprintDto sprintDto : list ) {
            list1.add( sprintDtoToSprint( sprintDto ) );
        }

        return list1;
    }

    protected UserStory userStoryDtoToUserStory(UserStoryDto userStoryDto) {
        if ( userStoryDto == null ) {
            return null;
        }

        UserStory.UserStoryBuilder userStory = UserStory.builder();

        userStory.name( userStoryDto.getName() );
        userStory.description( userStoryDto.getDescription() );
        userStory.attachments( attachmentsDtoListToAttachmentList( userStoryDto.getAttachments() ) );
        userStory.storyPoints( userStoryDto.getStoryPoints() );
        userStory.userStoryStatus( userStoryDto.getUserStoryStatus() );
        userStory.sprints( sprintDtoListToSprintList( userStoryDto.getSprints() ) );

        return userStory.build();
    }

    protected List<UserStory> userStoryDtoListToUserStoryList(List<UserStoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UserStory> list1 = new ArrayList<UserStory>( list.size() );
        for ( UserStoryDto userStoryDto : list ) {
            list1.add( userStoryDtoToUserStory( userStoryDto ) );
        }

        return list1;
    }

    protected Sprint sprintDtoToSprint(SprintDto sprintDto) {
        if ( sprintDto == null ) {
            return null;
        }

        Sprint.SprintBuilder sprint = Sprint.builder();

        sprint.name( sprintDto.getName() );
        sprint.beginDate( sprintDto.getBeginDate() );
        sprint.endDate( sprintDto.getEndDate() );
        sprint.goalDescription( sprintDto.getGoalDescription() );
        sprint.sprintStatus( sprintDto.getSprintStatus() );
        sprint.userStories( userStoryDtoListToUserStoryList( sprintDto.getUserStories() ) );

        return sprint.build();
    }
}
