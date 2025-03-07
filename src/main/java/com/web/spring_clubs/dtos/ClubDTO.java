package com.web.spring_clubs.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

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
        @Past
        LocalDate foundedAt,
        @NotBlank
        String stadium,
        @NotBlank
        String logoPath
) {
}
