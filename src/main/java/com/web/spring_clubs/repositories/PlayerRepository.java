package com.web.spring_clubs.repositories;

import com.web.spring_clubs.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
