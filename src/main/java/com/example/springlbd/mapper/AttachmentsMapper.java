package com.example.springlbd.mapper;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.entity.Attachment;
import org.mapstruct.*;

import java.util.Set;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
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
