package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

@Table(name = "players")
@Entity
public class Player extends Employee {
    @NotEmpty
    private String position;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;

    public Player(String name, double salary, String country, LocalDate bornAt, LocalDate debutAt,
                  double height, double weight, String photoPath, String position, Club currentClub) {
        super(name, salary, country, bornAt, debutAt, height, weight, photoPath);
        this.position = position;
        this.currentClub = currentClub;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }
}
