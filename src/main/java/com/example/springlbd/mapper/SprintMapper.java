package com.example.springlbd.mapper;

import com.example.springlbd.dto.SprintDto.SprintDto;
import com.example.springlbd.entity.Sprint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SprintMapper {
    SprintDto mapEntityToDto(Sprint source);
    Sprint mapDtoToEntity(SprintDto destination);
}
