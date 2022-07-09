package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.entity.Attachment;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AttachmentsMapper {

    @Named("baseEntityToDto")
    AttachmentsDto mapEntityToDto(Attachment source);
    @Named("baseDtoToEntity")
    Attachment mapDtoToEntity(AttachmentsDto destination);

    @IterableMapping(qualifiedByName = "baseEntityToDto")
    Set<AttachmentsDto> mapEntityToDto(Set<Attachment> source);
    @IterableMapping(qualifiedByName = "baseDtoToEntity")
    Set<Attachment> mapDtoToEntity(Set<AttachmentsDto> destination);

}
