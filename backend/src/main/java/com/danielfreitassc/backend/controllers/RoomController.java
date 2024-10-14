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

import com.danielfreitassc.backend.dtos.RoomRequestDto;
import com.danielfreitassc.backend.dtos.RoomResponseDto;
import com.danielfreitassc.backend.services.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponseDto create(@RequestBody @Valid RoomRequestDto roomRequestDto) {
        return roomService.create(roomRequestDto);
    }

    @GetMapping
    public Page<RoomResponseDto> getAll(Pageable pageable,@RequestParam(name="search", required=false, defaultValue="") String search) {
        return  roomService.getAll(pageable,search);
    }

    @GetMapping("/{id}")
    public RoomResponseDto getById(@PathVariable UUID id) {
        return  roomService.getById(id);
    }

    @PutMapping("/{id}")
    public RoomResponseDto update(@PathVariable UUID id, @RequestBody @Valid RoomRequestDto roomRequestDto) {
        return roomService.update(id, roomRequestDto);
    }

    @DeleteMapping("/{id}")
    public RoomResponseDto delete(@PathVariable UUID id) {
        return  roomService.delete(id);
    }
}
