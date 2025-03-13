package com.web.spring_clubs.security.controllers;

import com.web.spring_clubs.security.dtos.AuthDTO;
import com.web.spring_clubs.security.dtos.RegisterDTO;
import com.web.spring_clubs.security.repositories.UserRepository;
import com.web.spring_clubs.security.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationService service;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO) {
        service.login(authDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO RegisterDTO) {
        service.register(RegisterDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
