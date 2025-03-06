package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.repositories.PlayerRepository;
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

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock
    PlayerRepository playerRepository;

    @Autowired
    @InjectMocks
    PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should get all players successfully")
    void findAllSuccess() {
        // Arrange
        Player player1 = new Player("Jogador 1", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player1.png", "Ofensivo", null);
        Player player2 = new Player("Jogador 2", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player2.png", "Ofensivo", null);
        List<Player> players = List.of(player1, player2);
        when(playerRepository.findAll()).thenReturn(players);

        // Act
        List<Player> result = playerService.findAll();

        // Assert
        assertAll(() -> {
            assertNotNull(result);
            assertEquals(players.size(), result.size());
            assertEquals(players.get(0).getId(), result.get(0).getId());
            assertEquals(players.get(1).getId(), result.get(1).getId());
        });

        verify(playerRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("Should get a specific player successfully")
    void findPlayerByIdSuccess() {
        // Arrange
        Player player = new Player("Jogador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player.png", "Ofensivo", null);
        player.setId(1L);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        // Act
         Player result = playerService.findPlayerById(1L);

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(player.getId(), result.getId()),
                () -> assertEquals(player.getName(), result.getName())
                );

        verify(playerRepository, times(1)).findById(player.getId());
    }

    @Test
    @DisplayName("Should throw an exception when trying to get a non-existing player by ID")
    void findPlayerByIdFailure() {
        // Arrange
        when(playerRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> playerService.findPlayerById(1L)
        );

        verify(playerRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should get the new player created successfully")
    void createPlayerSuccess() {
        // Arrange
        Player player = new Player("Jogador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player.png", "Ofensivo", null);
        player.setId(1L);
        when(playerRepository.save(player)).thenReturn(player);

        // Act
        Player result = playerService.createPlayer(player);

        // Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(player.getId(), result.getId()),
                () -> assertEquals(player.getName(), result.getName())
        );

        verify(playerRepository, times(1)).save(player);
    }

    // TODO: createPlayerFailure()

    @Test
    @DisplayName("Should update and get the updated player successfully")
    void updatePlayerSuccess() {
        Player currentPlayer = new Player("Jogador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player.png", "Ofensivo", null);
        currentPlayer.setId(1L);
        String currentName = currentPlayer.getName();
        Player modifiedPlayer = new Player("Jogador Modificado", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player.png", "Ofensivo", null);
        modifiedPlayer.setId(1L);
        when(playerRepository.findById(currentPlayer.getId())).thenReturn(Optional.of(currentPlayer));
        when(playerRepository.save(any(Player.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Player result = playerService.updatePlayer(modifiedPlayer.getId(), modifiedPlayer);

        // Assert
        assertNotNull(result);
        assertEquals(currentPlayer.getId(), result.getId());
        assertEquals(modifiedPlayer.getName(), result.getName());
        assertNotEquals(currentName, result.getName());

        verify(playerRepository, times(1)).save(currentPlayer);

    }

    @Test
    @DisplayName("Should throw an exception when trying to update a non-existing player by ID")
    void updatePlayerFailureNotFound() {
        // Arrange
        Player player = new Player("Jogador", 100, "Brasil", LocalDate.now(),
                LocalDate.now(), 180, 100, "/images/test_player.png", "Ofensivo", null);
        player.setId(1L);
        when(playerRepository.findById(player.getId())).thenReturn(Optional.empty());

        // Act and assert
        assertThrows(EntityNotFoundException.class,
                () -> playerService.updatePlayer(player.getId(), player));

        verify(playerRepository, times(1)).findById(player.getId());
    }

    // TODO: updatePlayerFailureInvalidData()

    @Test
    @DisplayName("Should delete a player successfully")
    void deletePlayerSuccess() {
        // Arrange
        Long playerId = 1L;
        doNothing().when(playerRepository).deleteById(playerId);

        // Act
        playerService.deletePlayer(playerId);

        verify(playerRepository, times(1)).deleteById(playerId);
    }

    // TODO: deletePlayerFailure()

}