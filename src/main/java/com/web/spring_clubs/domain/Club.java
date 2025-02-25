package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Table(name = "clubs")
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String surname;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotNull
    private LocalDate foundedAt;

    @NotBlank
    private String stadium;
    private Coach coach;

    @NotBlank
    private String logoUrl;
}
