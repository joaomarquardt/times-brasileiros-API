package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

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
