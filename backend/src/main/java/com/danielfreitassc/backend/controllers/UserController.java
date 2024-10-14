package com.danielfreitassc.backend.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitassc.backend.dtos.UserRequestDto;
import com.danielfreitassc.backend.dtos.UserResponseDto;
import com.danielfreitassc.backend.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody @Valid UserRequestDto userRequestDto) {
        return  userService.create(userRequestDto);
    }

    @GetMapping
    public Page<UserResponseDto> getAllUsers(Pageable pageable, @RequestParam(value="search",required=false,defaultValue="") String search) {
        return userService.getAllUsers(pageable, search);
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable UUID id) {
        return  userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable UUID id, @RequestBody @Valid UserRequestDto userRequestDto) {
        return  userService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public UserResponseDto delete(@PathVariable UUID id) {
        return  userService.delete(id);
    }
}   
