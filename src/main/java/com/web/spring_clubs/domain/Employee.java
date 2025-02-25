package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Employee {

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;

    @Positive
    private double salary;

    @NotBlank
    private String nationality;

    @NotNull
    @Past
    private LocalDate bornAt;

    @Positive
    private double height;

    @Positive
    private double weight;

    private String photoUrl;
}
