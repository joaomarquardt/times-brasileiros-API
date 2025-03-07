package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.dtos.CoachDTO;
import com.web.spring_clubs.mappers.CoachMapper;
import com.web.spring_clubs.repositories.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository repository;

    @Autowired
    private CoachMapper mapper;

    public List<CoachDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public CoachDTO findCoachById(Long id) {
        Coach entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach with ID" + id + " not found"));
        return mapper.toDTO(entity);
    }

    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach createdEntity = repository.save(mapper.toEntity(coachDTO));
        return mapper.toDTO(createdEntity);
    }

    public CoachDTO updateCoach(Long id, CoachDTO coachDTO) {
        Coach entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach with ID " + id + " not found"));
        mapper.updateEntityFromDTO(coachDTO, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    public void deleteCoach(Long id) {
        repository.deleteById(id);
    }
}
