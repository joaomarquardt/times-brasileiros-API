package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Table(name = "coaches")
@Entity
public class Coach extends Employee {
    @NotBlank
    private String tacticalStyle;

    @NotBlank
    private String trainingMethodology;

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;

    public Coach(String name, double salary, String country, LocalDate bornAt, LocalDate debutAt, double height, double weight, String photoPath,
                 String tacticalStyle, String trainingMethodology, Club currentClub) {
        super(name, salary, country, bornAt, debutAt, height, weight, photoPath);
        this.tacticalStyle = tacticalStyle;
        this.trainingMethodology = trainingMethodology;
        this.currentClub = currentClub;
    }



    public String getTacticalStyle() {
        return tacticalStyle;
    }

    public void setTacticalStyle(String tacticalStyle) {
        this.tacticalStyle = tacticalStyle;
    }

    public String getTrainingMethodology() {
        return trainingMethodology;
    }

    public void setTrainingMethodology(String trainingMethodology) {
        this.trainingMethodology = trainingMethodology;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }
}
