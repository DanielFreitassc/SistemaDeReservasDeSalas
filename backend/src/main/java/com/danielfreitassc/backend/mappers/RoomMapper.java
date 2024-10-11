package com.danielfreitassc.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.danielfreitassc.backend.dtos.RoomRequestDto;
import com.danielfreitassc.backend.dtos.RoomResponseDto;
import com.danielfreitassc.backend.models.RoomEntity;

@Mapper(componentModel="spring")
public interface RoomMapper {
    RoomResponseDto toDto(RoomEntity roomEntity);


    @Mapping(target="id",ignore=true)
    @Mapping(target="createdAt", ignore=true)
    RoomEntity toEntity(RoomRequestDto roomRequestDto);
}
