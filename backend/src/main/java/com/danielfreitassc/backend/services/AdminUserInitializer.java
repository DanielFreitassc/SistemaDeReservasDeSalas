package com.danielfreitassc.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.danielfreitassc.backend.dtos.UserRequestDto;
import com.danielfreitassc.backend.mappers.UserMapper;
import com.danielfreitassc.backend.models.UserRole;
import com.danielfreitassc.backend.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminUserInitializer {
    private  final UserMapper userMapper;
    private final UserRepository userRepository;
    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @PostConstruct
    public void init() {

        if(userRepository.findByUsername(adminUsername) != null) {
            System.out.println("Erro");
        } else {
            String encryptedPassword =  new BCryptPasswordEncoder().encode(adminPassword);
            UserRequestDto adminUserDTO = new UserRequestDto("admin","admin" ,adminUsername, encryptedPassword, UserRole.ADMIN);
            
            userRepository.save(userMapper.toEntity(adminUserDTO));
        }
    }
}