package com.danielfreitassc.backend.repositories;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private RoomRepository roomRepository;
    @Autowired
    EntityManager entityManager;
    
    @Test
    @DisplayName("Busca paginada")
    void findAllCase1() {
        RoomRequestDto roomRequestDto = new RoomRequestDto("Fulano", "F1A4", "Prédio 10", 20, new BigDecimal(200));
        createRoom(roomRequestDto);
        Pageable pageable = PageRequest.of(0, 10);

        Page<RoomEntity> roomsPage = roomRepository.findAll(pageable,"Fulano");

        assertThat(roomsPage);
    }

    private RoomResponseDto  createRoom(RoomRequestDto roomRequestDto) {
        RoomEntity roomEntity = roomMapper.toEntity(roomRequestDto);
        entityManager.persist(roomEntity);
        return  roomMapper.toDto(roomEntity);
    }
}
