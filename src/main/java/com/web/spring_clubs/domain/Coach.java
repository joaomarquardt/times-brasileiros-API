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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
