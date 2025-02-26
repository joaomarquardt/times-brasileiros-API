package com.web.spring_clubs.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClubDTO(
        @NotBlank
        String name,
        String surname,
        @NotBlank
        String state,
        @NotBlank
        String city,
        @NotNull
        LocalDate foundedAt,
        @NotBlank
        String stadium,
        @NotBlank
        String logoPath
) {
}
