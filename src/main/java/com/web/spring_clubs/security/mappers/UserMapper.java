package com.web.spring_clubs.security.mappers;

import com.web.spring_clubs.security.domain.User;
import com.web.spring_clubs.security.dtos.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);

    User toEntity(UserDTO dto);

    List<UserDTO> toDTOList(List<User> entities);

    List<User> toEntityList(List<UserDTO> dtos);
}
