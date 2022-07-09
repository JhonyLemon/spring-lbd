package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.entity.Attachments;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AttachmentsMapper {

    @Named("baseEntityToDto")
    AttachmentsDto mapEntityToDto(Attachments source);
    @Named("baseDtoToEntity")
    Attachments mapDtoToEntity(AttachmentsDto destination);

    @IterableMapping(qualifiedByName = "baseEntityToDto")
    Set<AttachmentsDto> mapEntityToDto(Set<Attachments> source);
    @IterableMapping(qualifiedByName = "baseDtoToEntity")
    Set<Attachments> mapDtoToEntity(Set<AttachmentsDto> destination);

}
