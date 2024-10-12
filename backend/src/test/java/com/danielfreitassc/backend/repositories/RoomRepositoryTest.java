package com.danielfreitassc.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.danielfreitassc.backend.dtos.RoomRequestDto;
import com.danielfreitassc.backend.dtos.RoomResponseDto;
import com.danielfreitassc.backend.mappers.RoomMapper;
import com.danielfreitassc.backend.models.RoomEntity;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class RoomRepositoryTest {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    EntityManager entityManager;
    
  
    private RoomResponseDto  createRoom(RoomRequestDto roomRequestDto) {
        RoomEntity roomEntity = roomMapper.toEntity(roomRequestDto);
        entityManager.persist(roomEntity);
        return  roomMapper.toDto(roomEntity);
    }
}
