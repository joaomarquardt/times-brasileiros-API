package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Table(name = "players")
@Entity
public class Player extends Employee {
    @NotEmpty
    private String position;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;

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
