package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @PositiveOrZero
    private double salary;

    @NotBlank
    private String country;

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

    private String photoPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
