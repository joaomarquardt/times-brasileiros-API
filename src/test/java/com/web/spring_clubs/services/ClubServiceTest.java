package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.dtos.ClubDTO;
import com.web.spring_clubs.mappers.ClubMapper;
import com.web.spring_clubs.repositories.ClubRepository;
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

    @Spy
    private ClubMapper mapper = Mappers.getMapper(ClubMapper.class);

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
        Club club1 = new Club("Test club1", "Test club1",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club1.png");
        Club club2 = new Club("Test club2", "Test club2",
                "SP", "São Paulo", LocalDate.now(), "Vila Belmiro", "/images/test_club2.png");
        List<Club> clubs = List.of(club1, club2);
        when(clubRepository.findAll()).thenReturn(clubs);

        // Act
        List<ClubDTO> result = clubService.findAll();

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(clubs.size(), result.size()),
                () -> assertEquals(clubs.get(0).getName(), result.get(0).name()),
                () -> assertEquals(clubs.get(1).getName(), result.get(1).name())
        );

        verify(clubRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get a specific club successfully")
    void findClubByIdSuccess() {
        // Arrange
        Club club = new Club("Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        club.setId(1L);
        when(clubRepository.findById(club.getId())).thenReturn(Optional.of(club));

        // Act and Assert
        assertDoesNotThrow(() -> {
            ClubDTO result = clubService.findClubById(1L);
            assertAll(
                    () -> assertNotNull(result),
                    () -> assertEquals(club.getName(), result.name())
            );
        });

        verify(clubRepository, times(1)).findById(club.getId());
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
        Club club = new Club("Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        ClubDTO clubDTO = new ClubDTO("Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        when(clubRepository.save(any(Club.class))).thenReturn(club);

        // Act and assert
        ClubDTO result = clubService.createClub(clubDTO);
        assertAll(
            () -> assertNotNull(result),
            () -> assertEquals(club.getName(), result.name())
        );

        verify(clubRepository, times(1)).save(any(Club.class));
    }

    // TODO: createClubFailure()

    @Test
    @DisplayName("Should update and get the updated club successfully")
    void updateClubSuccess() {
        // Arrange
        Club currentClub = new Club("Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        currentClub.setId(1L);
        ClubDTO modifiedClub = new ClubDTO("Textor club", "Textor club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Engenhão", "/images/test_club.png");
        when(clubRepository.findById(anyLong())).thenReturn(Optional.of(currentClub));
        when(clubRepository.save(any(Club.class))).thenAnswer(invocation -> {
          Club savedClub = invocation.getArgument(0);
            return savedClub;
        });

        // Act
        ClubDTO result = clubService.updateClub(currentClub.getId(), modifiedClub);

        // Assert
        assertNotNull(result);
        assertEquals(modifiedClub.name(), result.name());
        assertEquals(modifiedClub.stadium(), result.stadium());

        verify(clubRepository, times(1)).save(any(Club.class));
    }

    @Test
    @DisplayName("Should throw an exception when trying to update a non-existing club by ID")
    void updateClubFailureNotFound() {
        // Arrange
        ClubDTO clubDTO = new ClubDTO("Test club", "Test club",
                "RJ", "Rio de Janeiro", LocalDate.now(), "Maracanã", "/images/test_club.png");
        when(clubRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> clubService.updateClub(1L, clubDTO)
        );

        verify(clubRepository, times(1)).findById(anyLong());
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