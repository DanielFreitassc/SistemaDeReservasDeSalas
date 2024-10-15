// package com.danielfreitassc.backend.services;

// import java.math.BigDecimal;
// import java.sql.Timestamp;
// import java.time.Instant;
// import java.util.UUID;

// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import static org.mockito.ArgumentMatchers.any;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import static org.mockito.Mockito.doReturn;
// import static org.mockito.Mockito.doThrow;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.test.context.ActiveProfiles;

// import com.danielfreitassc.backend.dtos.RoomRequestDto;
// import com.danielfreitassc.backend.dtos.RoomResponseDto;
// import com.danielfreitassc.backend.mappers.RoomMapper;
// import com.danielfreitassc.backend.models.RoomEntity;
// import com.danielfreitassc.backend.repositories.RoomRepository;

// @ActiveProfiles("test")
// @ExtendWith(MockitoExtension.class)
// public class RoomServiceTest {
//     @InjectMocks
//     private RoomService roomService;

//     @Mock
//     private RoomRepository roomRepository;
    
//     @Mock
//     private RoomMapper roomMapper;

//     @Test
//     @DisplayName("Should create a room with success")
//     public void shouldCreateRoom() {
//         // Arrange

//         RoomEntity roomEntity = new RoomEntity(
//             UUID.randomUUID(),
//             "Sala de Reunião",
//             "AC466",
//             "Bloco C",
//             40,
//             BigDecimal.valueOf(299),
//             Timestamp.from(Instant.now())
//         );

//         RoomResponseDto responseDto = new RoomResponseDto(
//         roomEntity.getId(),
//         roomEntity.getName(),
//         roomEntity.getRoomNumber(),
//         roomEntity.getLocation(),
//         roomEntity.getCapacity(),
//         roomEntity.getPrice()
//         );
        
//         // Mockando o comportamento do RoomMapper
//         doReturn(roomEntity).when(roomMapper).toEntity(any(RoomRequestDto.class));
//         doReturn(responseDto).when(roomMapper).toDto(any(RoomEntity.class));

//         // Mockando o comportamento do RoomRepository
//         doReturn(roomEntity).when(roomRepository).save(any(RoomEntity.class));

//         RoomRequestDto input = new RoomRequestDto(
//             "Sala de Reunião",
//             "AC466",
//             "Bloco C",
//             20,
//             BigDecimal.valueOf(299)
//         );
//         // Act
//         var output = roomService.create(input);
//         // Assert
//         assertNotNull(output);
//     }

//     @Test
//     @DisplayName("Should throw exception when error occurs")
//     public void shouldThrowExceptionWhenErrorOccurs() {
//         // Arrange

//         RoomEntity roomEntity = new RoomEntity(
//             UUID.randomUUID(),
//             "Sala de Reunião",
//             "AC466",
//             "Bloco C",
//             50,
//             BigDecimal.valueOf(100),
//             Timestamp.from(Instant.now())
//         );
    
//         // Mockando o comportamento do RoomRepository
//         doThrow(new RuntimeException()).when(roomRepository).save(any(RoomEntity.class));

//         RoomRequestDto input = new RoomRequestDto(
//             "Sala de renderização",
//             "AF455",
//             "Bloco F",
//             50,
//             BigDecimal.valueOf(299)
//         );
//         // Act
//         assertThrows(RuntimeException.class, () -> roomService.create(input));
//         // Assert
//     }

// }
