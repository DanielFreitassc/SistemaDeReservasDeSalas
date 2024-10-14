package com.danielfreitassc.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.danielfreitassc.backend.dtos.AuthenticationDTO;
import com.danielfreitassc.backend.models.UserEntity;

@Mapper(componentModel = "spring")
public interface  AuhtenticationMapper {
    
    AuthenticationDTO toDto(UserEntity user);

    @Mapping(target="id", ignore=true)
    @Mapping(target="name", ignore=true)
    @Mapping(target="lastName", ignore=true)
    @Mapping(target="role", ignore=true)
    @Mapping(target="createdAt", ignore=true)
    @Mapping(target="loginAttempts", ignore=true)
    @Mapping(target="lockoutExpiration",ignore=true)
    @Mapping(target="authorities",ignore=true)
    UserEntity toEntity(AuthenticationDTO authenticationDTO); 
}
