package com.web.spring_clubs.controllers;

import com.web.spring_clubs.domain.Coach;
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
    public ResponseEntity<List<Coach>> findAll() {
        List<Coach> entities = service.findAll();
        return new ResponseEntity<>(entities,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCoachById(@PathVariable(value = "id") Long id) {
        Coach entity = service.findCoachById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCoach(@RequestBody Coach coach) {
        Coach entity = service.createCoach(coach);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCoach(@PathVariable(value = "id") Long id, @RequestBody Coach coach) {
        Coach entity = service.updateCoach(id, coach);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") Long id) {
        service.deleteCoach(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
