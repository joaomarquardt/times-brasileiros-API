package com.web.spring_clubs.dtos;

import com.web.spring_clubs.domain.Club;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PlayerDTO(
        @NotBlank(message = "Must be not blank")
        @Size(min = 2, max = 100, message = "Must be of 2 - 100 characters")
        String name,
        @PositiveOrZero(message = "Must be greater than or equal to 0")
        double salary,
        @NotBlank
        @Size(min = 2, max = 50, message = "Must be of 2 - 50 characters")
        String country,
        @NotNull(message = "Must be not null")
        @Past(message = "Must be in the past")
        LocalDate bornAt,
        @NotNull(message = "Must be not null")
        @Past(message = "Must be in the past")
        LocalDate debutAt,
        @Positive(message = "Must be greater than 0cm")
        double height,
        @Positive(message = "Must be greater than 0kg")
        double weight,
        String photoPath,
        @NotBlank(message = "Must be not blank")
        String position,
        Club currentClub
) {
}
