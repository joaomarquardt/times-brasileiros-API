package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.dtos.CoachDTO;
import com.web.spring_clubs.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coaches")
public class CoachController {

    @Autowired
    private CoachService service;

    @GetMapping
    public ResponseEntity<List<CoachDTO>> findAll() {
        List<CoachDTO> dtos = service.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCoachById(@PathVariable(value = "id") Long id) {
        CoachDTO dto = service.findCoachById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCoach(@RequestBody CoachDTO coachDTO) {
        CoachDTO dto = service.createCoach(coachDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCoach(@PathVariable(value = "id") Long id, @RequestBody CoachDTO coachDTO) {
        CoachDTO dto = service.updateCoach(id, coachDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") Long id) {
        service.deleteCoach(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
