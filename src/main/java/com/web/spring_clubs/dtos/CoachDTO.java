package com.web.spring_clubs.dtos;

import com.web.spring_clubs.domain.Club;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CoachDTO(
        @NotBlank
        String name,
        @PositiveOrZero
        double salary,
        @NotBlank
        String country,
        @NotNull
        @Past
        LocalDate bornAt,
        @NotNull
        @Past
        LocalDate debutAt,
        @Positive
        double height,
        @Positive
        double weight,
        String photoPath,
        @NotBlank
        String tacticalStyle,
        @NotBlank
        String trainingMethodology,
        Club currentClub
) {
}
