package com.danielfreitassc.backend.services;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.dtos.UserRequestDto;
import com.danielfreitassc.backend.dtos.UserResponseDto;
import com.danielfreitassc.backend.mappers.UserMapper;
import com.danielfreitassc.backend.models.UserEntity;
import com.danielfreitassc.backend.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserResponseDto create(UserRequestDto userRequestDto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userRequestDto)));
    }

    public Page<UserResponseDto> getAllUsers(Pageable pageable, String search) {
        Page<UserEntity> users = userRepository.findAll(pageable, search);
        return users.map(userMapper::toDto);
    }

    public UserResponseDto getUserById(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        return userMapper.toDto(user.get());
    }

    public UserResponseDto update(UUID id, UserRequestDto userRequestDto) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        UserEntity userEntity = userMapper.toEntity(userRequestDto);
        userEntity.setId(id);
        return userMapper.toDto(userRepository.save(userEntity));
    }

    public UserResponseDto delete(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        userRepository.delete(user.get());
        return userMapper.toDto(user.get());
    }
}
