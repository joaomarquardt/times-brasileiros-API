package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.repositories.ClubRepository;
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
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class ClubServiceTest {
    @Mock
    private ClubRepository clubRepository;

    @Autowired
    @InjectMocks
    ClubService clubService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /// AAA
    /// Arrange
    /// Act
    /// Assert

    @Test
    @DisplayName("Should get all clubs successfully")
    void findAllSuccess() {
        // Arrange
        Club club1 = new Club(1L, "Test club1", "Test club1",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club1.png");
        Club club2 = new Club(2L, "Test club2", "Test club2",
                "SP", "São Paulo", LocalDate.now(), "Vila Belmiro", "/images/test_club2.png");
        List<Club> clubs = List.of(club1, club2);
        when(clubRepository.findAll()).thenReturn(clubs);

        // Act
        List<Club> result = clubService.findAll();

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(2, result.size()),
                () -> assertEquals(club1, result.get(0)),
                () -> assertEquals(club2, result.get(1))
        );

        verify(clubRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get a specific club successfully")
    void findClubByIdSuccess() {
        // Arrange
        Club club = new Club(1L, "Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));

        // Act and Assert
        assertDoesNotThrow(() -> {
            Club result = clubService.findClubById(1L);
            assertAll(
                    () -> assertNotNull(result),
                    () -> assertEquals("Test club", result.getName())
            );
        });

        verify(clubRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw an exception when trying to get a non-existing club by ID")
    void findClubByIdFailure() {
        // Arrange
        when(clubRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> clubService.findClubById(1L)
        );

        verify(clubRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should get the new club created successfully")
    void createClubSuccess() {
        // Arrange
        Club club = new Club(1L, "Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        when(clubRepository.save(club)).thenReturn(club);

        // Act and assert
        Club result = clubService.createClub(club);
        assertAll(
            () -> assertNotNull(result),
            () -> assertEquals("Test club", result.getName()),
            () -> assertEquals(1L , result.getId())
        );

        verify(clubRepository, times(1)).save(club);
    }

    // TODO: createClubFailure()

    @Test
    @DisplayName("Should update and get the updated club successfully")
    void updateClubSuccess() {
        // Arrange
        Club currentClub = new Club(1L, "Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        Club modifiedClub = new Club(1L, "Textor club", "Textor club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Engenhão", "/images/test_club.png");
        when(clubRepository.findById(modifiedClub.getId())).thenReturn(Optional.of(modifiedClub));
        when(clubRepository.save(modifiedClub)).thenReturn(modifiedClub);

        // Act
        Club result = clubService.updateClub(modifiedClub.getId(), modifiedClub);

        // Assert
        assertNotNull(result);
        assertEquals("Textor club", result.getName());
        assertEquals(currentClub.getId(),result.getId());
        assertEquals("Engenhão", result.getStadium());

        verify(clubRepository, times(1)).save(modifiedClub);
    }

    @Test
    @DisplayName("Should throw an exception when trying to update a non-existing club by ID")
    void updateClubFailureNotFound() {
        // Arrange
        Club club = new Club(1L, "Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        when(clubRepository.findById(club.getId())).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> clubService.updateClub(club.getId(), club)
        );

        verify(clubRepository, times(1)).findById(club.getId());
    }

    // TODO: updateClubFailureInvalidData()

    @Test
    @DisplayName("Should delete a club successfully")
    void deleteClubSuccess() {
        // Arrange
        Long clubId = 1L;
        doNothing().when(clubRepository).deleteById(clubId);

        // Act
        clubService.deleteClub(clubId);

        verify(clubRepository, times(1)).deleteById(clubId);
    }

    // TODO deleteClubFailure
}