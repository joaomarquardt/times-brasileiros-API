package com.web.spring_clubs.security.dtos;

import com.web.spring_clubs.security.domain.UserRole;

public record UserDTO(
        String username,
        String email,
        UserRole role
) {
}
