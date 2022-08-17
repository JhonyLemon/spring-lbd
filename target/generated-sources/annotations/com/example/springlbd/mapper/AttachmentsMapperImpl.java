package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.entity.Attachment;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T16:27:49+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class AttachmentsMapperImpl implements AttachmentsMapper {

    @Override
    public AttachmentsDto mapEntityToDto(Attachment source) {
        if ( source == null ) {
            return null;
        }

        AttachmentsDto attachmentsDto = new AttachmentsDto();

        attachmentsDto.setAttachment( byteArrayToByteArray( source.getAttachment() ) );
        attachmentsDto.setName( source.getName() );
        attachmentsDto.setUserStory( source.getUserStory() );

        return attachmentsDto;
    }

    @Override
    public Attachment mapDtoToEntity(AttachmentsDto destination) {
        if ( destination == null ) {
            return null;
        }

        Attachment.AttachmentBuilder attachment = Attachment.builder();

        attachment.attachment( byteArrayTobyteArray( destination.getAttachment() ) );
        attachment.name( destination.getName() );
        attachment.userStory( destination.getUserStory() );

        return attachment.build();
    }

    @Override
    public Set<AttachmentsDto> mapEntityToDto(Set<Attachment> source) {
        if ( source == null ) {
            return null;
        }

        Set<AttachmentsDto> set = new LinkedHashSet<AttachmentsDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Attachment attachment : source ) {
            set.add( mapEntityToDto( attachment ) );
        }

        return set;
    }

    @Override
    public Set<Attachment> mapDtoToEntity(Set<AttachmentsDto> destination) {
        if ( destination == null ) {
            return null;
        }

        Set<Attachment> set = new LinkedHashSet<Attachment>( Math.max( (int) ( destination.size() / .75f ) + 1, 16 ) );
        for ( AttachmentsDto attachmentsDto : destination ) {
            set.add( mapDtoToEntity( attachmentsDto ) );
        }

        return set;
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
}
