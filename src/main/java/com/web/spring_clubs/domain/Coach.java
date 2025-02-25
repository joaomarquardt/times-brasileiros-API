package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

@Table(name = "coaches")
@Entity
public class Coach extends Employee {
    @PositiveOrZero
    private int yearsOfExperience;

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
