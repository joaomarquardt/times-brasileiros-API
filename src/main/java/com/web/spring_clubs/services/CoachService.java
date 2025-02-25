package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.repositories.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository repository;

    public List<Coach> findAll() {
        return repository.findAll();
    }

    public Coach findCoachById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach with ID" + id + " not found"));
    }

    public Coach createCoach(Coach coach) {
        Coach createdEntity = repository.save(coach);
        return createdEntity;
    }

    public Coach updateCoach(Long id, Coach coach) {
        Coach entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach with ID " + id + " not found"));
        entity.setName(coach.getName());
        entity.setCurrentClub(coach.getCurrentClub());
        entity.setBornAt(coach.getBornAt());
        entity.setHeight(coach.getHeight());
        entity.setWeight(coach.getWeight());
        entity.setNationality(coach.getNationality());
        entity.setDebutAt(coach.getDebutAt());
        entity.setSalary(coach.getSalary());
        entity.setPhotoUrl(coach.getPhotoUrl());

        Coach updatedEntity = repository.save(entity);
        return updatedEntity;
    }

    public void deleteCoach(Long id) {
        repository.deleteById(id);
    }
}
