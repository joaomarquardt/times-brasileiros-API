package com.web.spring_clubs.security.dtos;

public record AuthRequestDTO(
        String username,
        String password
) {
}
