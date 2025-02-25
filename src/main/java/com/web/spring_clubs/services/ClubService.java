package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.repositories.ClubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    public List<Club> findAll() {
        return repository.findAll();
    }

    public Club findClubById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Club with ID" + id + " not found"));
    }

    public Club createClub(Club club) {
        Club createdEntity = repository.save(club);
        return createdEntity;
    }

    public Club updateClub(Long id, Club club) {
        Club entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Club with ID " + id + " not found"));
        entity.setName(club.getName());
        entity.setSurname(club.getSurname());
        entity.setState(club.getState());
        entity.setCity(club.getCity());
        entity.setFoundedAt(club.getFoundedAt());
        entity.setStadium(club.getStadium());
        entity.setLogoUrl(club.getLogoUrl());

        Club updatedEntity = repository.save(entity);
        return updatedEntity;
    }

    public void deleteClub(Long id) {
        repository.deleteById(id);
    }
}
