package com.web.spring_clubs.security.dtos;

import com.web.spring_clubs.security.domain.UserRole;

public record UserResponseDTO(
        String username,
        String email,
        UserRole role
) {
}
