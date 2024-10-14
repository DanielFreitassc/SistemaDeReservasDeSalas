package com.danielfreitassc.backend.services;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if(userRepository.findByUsername(userRequestDto.username()) != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário já cadatrado");
        String encryptedPassword =  new BCryptPasswordEncoder().encode(userRequestDto.password());
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userRequestDto));
        userEntity.setPassword(encryptedPassword);
        return userMapper.toDto(userRepository.save(userEntity));
        
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

    public UserResponseDto patchUser(UUID id,  UserRequestDto userRequestDto) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado;");
        
        UserEntity userEntity = userOptional.get();
        
        if (userRequestDto.name() != null && !userRequestDto.name().isBlank()) {
            userEntity.setName(userRequestDto.name());
        }
        if (userRequestDto.username() != null && !userRequestDto.username().isBlank()) {
            userEntity.setUsername(userRequestDto.username());
        }
        if (userRequestDto.role() != userOptional.get().getRole()) {
            userEntity.setRole(userRequestDto.role());
        }
        if(userRequestDto.lastName() != null && !userRequestDto.lastName().isBlank()) {
            userEntity.setLastName(userRequestDto.lastName());
        }
        if (userRequestDto.password() != null && !userRequestDto.password().isBlank()) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(userRequestDto.password());
            userEntity.setPassword(encryptedPassword);
        }
       
        return userMapper.toDto(userRepository.save(userEntity));
    }


    public UserResponseDto delete(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        userRepository.delete(user.get());
        return userMapper.toDto(user.get());
    }
}
