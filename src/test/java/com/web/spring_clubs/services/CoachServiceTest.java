package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.dtos.CoachDTO;
import com.web.spring_clubs.mappers.CoachMapper;
import com.web.spring_clubs.repositories.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoachServiceTest {

    @Mock
    private CoachRepository coachRepository;

    @Spy
    private CoachMapper mapper = Mappers.getMapper(CoachMapper.class);

    @Autowired
    @InjectMocks
    private CoachService coachService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should get all coaches successfully")
    void findAllSuccess() {
        // Arrange
        Coach coach1 = new Coach("Treinador1", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach1.png", "Ofensivo",
                "Intensivo", null);
        Coach coach2 = new Coach("Treinador2", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach2.png", "Defensivo",
                "Teórico", null);
        List<Coach> coaches = List.of(coach1, coach2);
        when(coachRepository.findAll()).thenReturn(coaches);

        // Act
        List<CoachDTO> result = coachService.findAll();

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(coaches.size(), result.size()),
                () -> assertEquals(coaches.get(0).getName(), result.get(0).name()),
                () -> assertEquals(coaches.get(1).getName(), result.get(1).name())
        );

        verify(coachRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get a specific coach successfully")
    void findCoachByIdSuccess() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        coach.setId(1L);
        when(coachRepository.findById(coach.getId())).thenReturn(Optional.of(coach));

        // Act
        CoachDTO result = coachService.findCoachById(1L);

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(coach.getName(), result.name())
        );

        verify(coachRepository, times(1)).findById(coach.getId());
    }

    @Test
    @DisplayName("Should throw an exception when trying to get a non-existing coach by ID")
    void findCoachByIdFailure() {
        // Arrange
        when(coachRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> coachService.findCoachById(1L)
        );

        verify(coachRepository, times(1)).findById(1L);

    }

    @Test
    @DisplayName("Should get the new coach created successfully")
    void createCoachSuccess() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        CoachDTO coachDTO = new CoachDTO("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        when(coachRepository.save(any(Coach.class))).thenReturn(coach);

        // Act
        CoachDTO result = coachService.createCoach(coachDTO);

        // Assert
        assertNotNull(result);
        assertEquals(coach.getName(), result.name());

        verify(coachRepository, times(1)).save(any(Coach.class));

    }

    // TODO: createPlayerFailure()

    @Test
    @DisplayName("Should update and get the updated coach successfully")
    void updateClubSuccess() {
        // Arrange
        Coach currentCoach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        String currentName = currentCoach.getName();
        currentCoach.setId(1L);
        CoachDTO modifiedCoach = new CoachDTO("Treinador modificado", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        when(coachRepository.findById(anyLong())).thenReturn(Optional.of(currentCoach));
        when(coachRepository.save(any(Coach.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        CoachDTO result = coachService.updateCoach(currentCoach.getId(), modifiedCoach);

        // Assert
        assertNotNull(result);
        assertEquals(modifiedCoach.name(), result.name());
        assertNotEquals(currentName, result.name());

        verify(coachRepository, times(1)).save(any(Coach.class));
    }

    // TODO: createCoachFailure()

    @Test
    @DisplayName("Should throw an exception when trying to update a non-existing coach by ID")
    void updateCoachFailureNotFound() {
        // Arrange
        CoachDTO coach = new CoachDTO("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        when(coachRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> coachService.updateCoach(1L, coach));

        verify(coachRepository, times(1)).findById(anyLong());
    }

    // TODO: updateCoachFailureInvalidData()

    @Test
    @DisplayName("Should delete a coach successfully")
    void deleteCoachSuccess() {
        // Arrange
        Long coachId = 1L;
        doNothing().when(coachRepository).deleteById(coachId);

        // Act
        coachService.deleteCoach(coachId);

        verify(coachRepository, times(1)).deleteById(coachId);
    }

    // TODO: deleteCoachFailure
}