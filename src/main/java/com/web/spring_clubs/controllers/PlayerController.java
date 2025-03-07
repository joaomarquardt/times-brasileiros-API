package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.dtos.PlayerDTO;
import com.web.spring_clubs.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> findAll() {
        List<PlayerDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findPlayerById(@PathVariable(value = "id") Long id) {
        PlayerDTO dto = service.findPlayerById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO dto = service.createPlayer(playerDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO dto = service.updatePlayer(id, playerDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "id") Long id) {
        service.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
