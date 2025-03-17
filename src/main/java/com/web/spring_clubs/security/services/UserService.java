package com.web.spring_clubs.security.services;

import com.web.spring_clubs.security.domain.User;
import com.web.spring_clubs.security.domain.UserRole;
import com.web.spring_clubs.security.dtos.UserResponseDTO;
import com.web.spring_clubs.security.exceptions.UnauthorizedAccessException;
import com.web.spring_clubs.security.mappers.UserMapper;
import com.web.spring_clubs.security.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<UserResponseDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public UserResponseDTO findUserById(Long id)  {
        User authenticadedUser = getAuthenticatedUser();
        if (!authenticadedUser.getId().equals(id) && !authenticadedUser.getRole().equals(UserRole.ADMIN)) {
            throw new UnauthorizedAccessException("User cannot access this request");
        }
        User entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID" + id + " not found"));
        return mapper.toDTO(entity);
    }

    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
