package com.danielfreitassc.backend.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danielfreitassc.backend.models.RoomEntity;

public interface  RoomRepository extends  JpaRepository<RoomEntity, UUID>{
    
    @Query("SELECT r FROM RoomEntity r WHERE UPPER(r.name) LIKE CONCAT('%', UPPER(:search),'%') ORDER BY r.createdAt DESC")
    Page<RoomEntity> findAll(Pageable pageable, String search);
}
