package com.web.spring_clubs.security.dtos;

import com.web.spring_clubs.security.domain.UserRole;

public record RegisterDTO(
        String username,
        String email,
        String password,
        UserRole role
) {
}
