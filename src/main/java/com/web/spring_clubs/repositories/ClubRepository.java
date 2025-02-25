package com.web.spring_clubs.repositories;

import com.web.spring_clubs.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
