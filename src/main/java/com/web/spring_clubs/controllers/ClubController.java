package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clubs")
public class ClubController {

    @Autowired
    private ClubService service;

    @GetMapping
    public ResponseEntity<List<Club>> findAll() {
        List<Club> entities = service.findAll();
        return new ResponseEntity<>(entities,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findClubById(@PathVariable(value = "id") Long id) {
        Club entity = service.findClubById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createClub(@RequestBody Club club) {
        Club entity = service.createClub(club);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateClub(@PathVariable(value = "id") Long id, @RequestBody Club club) {
        Club entity = service.updateClub(id, club);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "id") Long id) {
        service.deleteClub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
