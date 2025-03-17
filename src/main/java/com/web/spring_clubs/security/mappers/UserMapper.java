package com.web.spring_clubs.security.mappers;

import com.web.spring_clubs.security.domain.User;
import com.web.spring_clubs.security.dtos.UserResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toDTO(User entity);

    User toEntity(UserResponseDTO dto);

    List<UserResponseDTO> toDTOList(List<User> entities);

    List<User> toEntityList(List<UserResponseDTO> dtos);
}
