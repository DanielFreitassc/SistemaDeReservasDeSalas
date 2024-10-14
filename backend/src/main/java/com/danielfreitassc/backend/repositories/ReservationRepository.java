package com.danielfreitassc.backend.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danielfreitassc.backend.models.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID>{

    @Query("SELECT r FROM ReservationEntity r ORDER BY createdAt DESC")
    Page<ReservationEntity> findAllEntitys(Pageable pageable);
    
}
