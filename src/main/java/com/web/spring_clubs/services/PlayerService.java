package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.dtos.PlayerDTO;
import com.web.spring_clubs.mappers.PlayerMapper;
import com.web.spring_clubs.repositories.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private PlayerMapper mapper;

    public List<PlayerDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public PlayerDTO findPlayerById(Long id) {
        Player entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player with ID" + id + " not found"));
        return mapper.toDTO(entity);
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player createdEntity = repository.save(mapper.toEntity(playerDTO));
        return mapper.toDTO(createdEntity);
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Player entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player with ID " + id + " not found"));
        mapper.updateEntityFromDTO(playerDTO, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    public void deletePlayer(Long id) {
        repository.deleteById(id);
    }
}
