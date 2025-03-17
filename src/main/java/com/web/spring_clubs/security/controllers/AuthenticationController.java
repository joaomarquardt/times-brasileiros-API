package com.web.spring_clubs.security.controllers;

import com.web.spring_clubs.security.dtos.AuthRequestDTO;
import com.web.spring_clubs.security.dtos.AuthResponseDTO;
import com.web.spring_clubs.security.dtos.RegisterRequestDTO;
import com.web.spring_clubs.security.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthRequestDTO authDTO) {
        String token = service.login(authDTO);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDTO registerDTO) {
        service.register(registerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
