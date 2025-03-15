package com.web.spring_clubs.security.services;

import com.web.spring_clubs.security.domain.User;
import com.web.spring_clubs.security.dtos.AuthDTO;
import com.web.spring_clubs.security.dtos.RegisterDTO;
import com.web.spring_clubs.security.exceptions.RegisterConflictException;
import com.web.spring_clubs.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public String login(AuthDTO authDTO) {
        repository.findByUsername(authDTO.username()).orElseThrow(() -> new UsernameNotFoundException("User not found by username"));
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password());
        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);
            return tokenService.generateToken((User) auth.getPrincipal());
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    public void register(RegisterDTO registerDTO) {
        if (repository.findByUsername(registerDTO.username()).isPresent()) {
            throw new RegisterConflictException("Username is already in use");
        }
        if (repository.findByEmail(registerDTO.email()).isPresent()) {
            throw new RegisterConflictException("Email already in use");
        }
        String encryptedPassword = passwordEncoder.encode(registerDTO.password());
        User newUser = new User(registerDTO.username(), registerDTO.email(), encryptedPassword, registerDTO.role());
        repository.save(newUser);
    }
}
