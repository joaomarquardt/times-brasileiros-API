package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.dtos.PlayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDTO toDTO(Player entity);

    Player toEntity(PlayerDTO dto);

    List<PlayerDTO> toDTOList(List<Player> entities);

    List<Player> toEntityList(List<PlayerDTO> dtos);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(PlayerDTO dto, @MappingTarget Player entity);
}
