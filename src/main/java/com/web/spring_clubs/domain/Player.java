package com.web.spring_clubs.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Table(name = "players")
@Entity
public class Player extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ElementCollection
    @CollectionTable(name = "player_positions", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "position")
    private List<String> positions;
}
