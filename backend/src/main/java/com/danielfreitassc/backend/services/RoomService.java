package com.danielfreitassc.backend.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielfreitassc.backend.dtos.RoomRequestDto;
import com.danielfreitassc.backend.dtos.RoomResponseDto;
import com.danielfreitassc.backend.mappers.RoomMapper;
import com.danielfreitassc.backend.models.RoomEntity;
import com.danielfreitassc.backend.repositories.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;


    public RoomResponseDto create(RoomRequestDto roomRequestDto) {
        return roomMapper.toDto(roomRepository.save(roomMapper.toEntity(roomRequestDto)));
    }

    public Page<RoomResponseDto> getAll(Pageable pageable,String search) {
        Page<RoomEntity> rooms = roomRepository.findAll(pageable, search);
        return  rooms.map(roomMapper::toDto);
    }

    public RoomResponseDto getById(UUID id) {
        Optional<RoomEntity> room = roomRepository.findById(id);
        if(room.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma com este id");
        return  roomMapper.toDto(room.get());
    }

    public RoomResponseDto update(UUID id, RoomRequestDto roomRequestDto) {
        Optional<RoomEntity> room = roomRepository.findById(id);
        if(room.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma com este id");
        RoomEntity roomEntity = roomMapper.toEntity(roomRequestDto);
        roomEntity.setId(id);
        return roomMapper.toDto(roomRepository.save(roomEntity));
    }

    public RoomResponseDto delete(UUID id) {
        Optional<RoomEntity> room = roomRepository.findById(id);
        if(room.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma com este id");
        roomRepository.delete(room.get());
        return roomMapper.toDto(room.get());
    }
}
