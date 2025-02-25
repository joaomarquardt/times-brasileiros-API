package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.services.PlayerService;
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
    public ResponseEntity<List<Player>> findAll() {
        List<Player> entities = service.findAll();
        return new ResponseEntity<>(entities,HttpStatus.OK);
    }

    @GetMapping(value = "{/id}")
    public ResponseEntity<?> findPlayerById(@PathVariable(value = "id") Long id) {
        Player entity = service.findPlayerById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody Player player) {
        Player entity = service.createPlayer(player);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable(value = "id") Long id, @RequestBody Player player) {
        Player entity = service.updatePlayer(id, player);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "id") Long id) {
        service.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
