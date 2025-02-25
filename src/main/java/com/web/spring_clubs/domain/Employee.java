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

    @NotNull
    @Past
    private LocalDate debutAt;

    @Positive
    private double height;

    @Positive
    private double weight;

    private String photoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBornAt() {
        return bornAt;
    }

    public void setBornAt(LocalDate bornAt) {
        this.bornAt = bornAt;
    }

    public LocalDate getDebutAt() {
        return debutAt;
    }

    public void setDebutAt(LocalDate debutAt) {
        this.debutAt = debutAt;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
