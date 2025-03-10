package com.web.spring_clubs.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClubDTO(
        @NotBlank(message = "Must be not blank")
        @Size(min = 2, max = 80, message = "Must be of 2 - 80 characters")
        String name,
        @Size(min = 2, max = 80, message = "Must be of 2 - 50 characters")
        String surname,
        @NotBlank(message = "Must be not blank")
        @Size(min = 2, max = 2, message = "Must be exactly 2 characters")
        String state,
        @NotBlank(message = "Must be not blank")
        @Size(min = 2, max = 50, message = "Must be of 2 - 50 characters")
        String city,
        @NotNull(message = "Must be not null")
        @Past(message = "Must be in the past")
        LocalDate foundedAt,
        @NotBlank(message = "Must be not blank")
        @Size(min = 2, max = 50, message = "Must be of 2 - 50 characters")
        String stadium,
        String logoPath
) {}
