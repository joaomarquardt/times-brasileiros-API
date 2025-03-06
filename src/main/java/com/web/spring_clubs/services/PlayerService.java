package com.web.spring_clubs.services;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.repositories.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Player findPlayerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player with ID" + id + " not found"));
    }

    public Player createPlayer(Player player) {
        Player createdEntity = repository.save(player);
        return createdEntity;
    }

    public Player updatePlayer(Long id, Player player) {
        Player entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player with ID " + id + " not found"));
        entity.setName(player.getName());
        entity.setCurrentClub(player.getCurrentClub());
        entity.setBornAt(player.getBornAt());
        entity.setHeight(player.getHeight());
        entity.setWeight(player.getWeight());
        entity.setCountry(player.getCountry());
        entity.setDebutAt(player.getDebutAt());
        entity.setPosition(player.getPosition());
        entity.setSalary(player.getSalary());
        entity.setPhotoPath(player.getPhotoPath());

        Player updatedEntity = repository.save(entity);
        return updatedEntity;
    }

    public void deletePlayer(Long id) {
        repository.deleteById(id);
    }
}
