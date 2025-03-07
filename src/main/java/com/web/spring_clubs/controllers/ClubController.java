package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.dtos.ClubDTO;
import com.web.spring_clubs.services.ClubService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<ClubDTO>> findAll() {
        List<ClubDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findClubById(@PathVariable(value = "id") Long id) {
        ClubDTO dto = service.findClubById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createClub(@Valid @RequestBody ClubDTO clubDTO) {
        ClubDTO dto = service.createClub(clubDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateClub(@PathVariable(value = "id") Long id, @Valid @RequestBody ClubDTO clubDTO) {
        ClubDTO dto = service.updateClub(id, clubDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "id") Long id) {
        service.deleteClub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
