package com.danielfreitassc.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.danielfreitassc.backend.dtos.UserRequestDto;
import com.danielfreitassc.backend.dtos.UserResponseDto;
import com.danielfreitassc.backend.models.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toDto(UserEntity userEntity);
    
    @Mapping(target="id", ignore=true)
    @Mapping(target="createdAt", ignore=true)
    UserEntity toEntity(UserRequestDto userRequestDto);
}
