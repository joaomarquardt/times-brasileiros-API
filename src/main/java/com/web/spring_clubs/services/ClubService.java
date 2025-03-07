package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.dtos.ClubDTO;
import com.web.spring_clubs.mappers.ClubMapper;
import com.web.spring_clubs.repositories.ClubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    @Autowired
    private ClubMapper mapper;

    public List<ClubDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public ClubDTO findClubById(Long id) {
        Club entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Club with ID" + id + " not found"));
        return mapper.toDTO(entity);
    }

    public ClubDTO createClub(ClubDTO clubDTO) {
        Club createdEntity = repository.save(mapper.toEntity(clubDTO));
        return mapper.toDTO(createdEntity);
    }

    public ClubDTO updateClub(Long id, ClubDTO clubDTO) {
        Club entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Club with ID " + id + " not found"));
        mapper.updateEntityFromDTO(clubDTO, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    public void deleteClub(Long id) {
        repository.deleteById(id);
    }
}
