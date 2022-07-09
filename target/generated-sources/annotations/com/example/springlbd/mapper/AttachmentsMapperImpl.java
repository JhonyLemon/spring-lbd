package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.entity.Attachments;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T16:22:22+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class AttachmentsMapperImpl implements AttachmentsMapper {

    @Override
    public AttachmentsDto mapEntityToDto(Attachments source) {
        if ( source == null ) {
            return null;
        }

        AttachmentsDto attachmentsDto = new AttachmentsDto();

        attachmentsDto.setId( source.getId() );
        Byte[] attachment = source.getAttachment();
        if ( attachment != null ) {
            attachmentsDto.setAttachment( Arrays.copyOf( attachment, attachment.length ) );
        }
        attachmentsDto.setUserStory( source.getUserStory() );

        return attachmentsDto;
    }

    @Override
    public Attachments mapDtoToEntity(AttachmentsDto destination) {
        if ( destination == null ) {
            return null;
        }

        Attachments attachments = new Attachments();

        attachments.setId( destination.getId() );
        Byte[] attachment = destination.getAttachment();
        if ( attachment != null ) {
            attachments.setAttachment( Arrays.copyOf( attachment, attachment.length ) );
        }
        attachments.setUserStory( destination.getUserStory() );

        return attachments;
    }

    @Override
    public Set<AttachmentsDto> mapEntityToDto(Set<Attachments> source) {
        if ( source == null ) {
            return null;
        }

        Set<AttachmentsDto> set = new LinkedHashSet<AttachmentsDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Attachments attachments : source ) {
            set.add( mapEntityToDto( attachments ) );
        }

        return set;
    }

    @Override
    public Set<Attachments> mapDtoToEntity(Set<AttachmentsDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<Attachments> set = new LinkedHashSet<Attachments>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( AttachmentsDto attachmentsDto : destination ) {
            set.add( mapDtoToEntity( attachmentsDto ) );
        }

        return set;
    }
}
