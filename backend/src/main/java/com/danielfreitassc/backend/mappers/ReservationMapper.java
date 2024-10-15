package com.danielfreitassc.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.danielfreitassc.backend.dtos.ReservationRequestDto;
import com.danielfreitassc.backend.dtos.ReservationResponseDto;
import com.danielfreitassc.backend.models.ReservationEntity;

@Mapper(componentModel="spring")
public interface  ReservationMapper {
    @Mapping(target="room", source = "roomEntity")
    @Mapping(target="user", source = "userEntity")
    ReservationResponseDto toDto(ReservationEntity reservationEntity);

    @Mapping(target="id",ignore=true)
    @Mapping(target="createdAt",ignore=true)
    @Mapping(target="roomEntity.id",source="roomId")
    @Mapping(target="userEntity.id",source="userId")
    @Mapping(target="totalCost",ignore=true)
    @Mapping(target="status",ignore=true)
    ReservationEntity toEntity(ReservationRequestDto reservationRequestDto);
}
