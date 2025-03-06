package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.repositories.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
                "Intensivo", new Club(1L, "Test club1", "Test club1", "RJ",
                "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png"));
        Coach coach2 = new Coach("Treinador2", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach2.png", "Defensivo",
                "Teórico", new Club(1L, "Test club2", "Test club2", "SP",
                "São Paulo", LocalDate.now(), "Vila Belmiro", "/images/test_club.png"));
        List<Coach> coaches = List.of(coach1, coach2);
        when(coachRepository.findAll()).thenReturn(coaches);

        // Act
        List<Coach> result = coachService.findAll();

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(coaches.size(), result.size()),
                () -> assertEquals(coaches.get(0), result.get(0)),
                () -> assertEquals(coaches.get(1), result.get(1)),
                () -> assertEquals(coaches.get(0).getId(), result.get(0).getId()),
                () -> assertEquals(coaches.get(1).getId(), result.get(1).getId())
        );

        verify(coachRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get a specific coach successfully")
    void findCoachByIdSuccess() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", new Club(1L, "Test club", "Test club", "RJ",
                "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png"));
        coach.setId(1L);
        when(coachRepository.findById(1L)).thenReturn(Optional.of(coach));

        // Act
        Coach result = coachService.findCoachById(1L);

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(coach.getId(), result.getId()),
                () -> assertEquals(coach.getName(), result.getName())
        );

        verify(coachRepository, times(1)).findById(coach.getId());
    }

    @Test
    @DisplayName("Should throw an exception when trying to get a non-existing coach by ID")
    void findCoachByIdFailure() {
        // Arrange
        when(coachRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class, () -> {
            Coach result = coachService.findCoachById(1L);
        });

        verify(coachRepository, times(1)).findById(1L);

    }

    @Test
    @DisplayName("Should get the new coach created successfully")
    void createCoachSuccess() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", new Club(1L, "Test club", "Test club", "RJ",
                "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png"));
        coach.setId(1L);
        when(coachRepository.save(coach)).thenReturn(coach);

        // Act
        Coach result = coachService.createCoach(coach);

        // Assert
        assertNotNull(result);
        assertEquals(coach.getId(), result.getId());
        assertEquals(coach.getName(), result.getName());

        verify(coachRepository, times(1)).save(coach);

    }

    // TODO: createCoachFailure()

    @Test
    @DisplayName("Should throw an exception when trying to update a non-existing coach by ID")
    void updateCoachFailureNotFound() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        coach.setId(1L);
        when(coachRepository.findById(coach.getId())).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> coachService.updateCoach(coach.getId(), coach));

        verify(coachRepository, times(1)).findById(coach.getId());
    }

    // TODO: updateCoachFailureInvalidData()

    @Test
    @DisplayName("Should delete a coach successfully")
    void deleteCoachSuccess() {
        // Arrange
        Coach coach = new Coach("Treinador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_coach.png", "Ofensivo",
                "Intensivo", null);
        coach.setId(1L);
        doNothing().when(coachRepository).deleteById(anyLong());

        // Act
        coachService.deleteCoach(anyLong());

        verify(coachRepository, times(1)).deleteById(anyLong());
    }

    // TODO: deleteCoachFailure
}