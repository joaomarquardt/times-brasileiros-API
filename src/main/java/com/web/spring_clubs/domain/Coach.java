package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

@Table(name = "coaches")
@Entity
public class Coach extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    private int yearsOfExperience;
}
