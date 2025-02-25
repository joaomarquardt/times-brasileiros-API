package com.web.spring_clubs.repositories;

import com.web.spring_clubs.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
