package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Player;
import com.web.spring_clubs.dtos.PlayerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends GenericMapper<Player, PlayerDTO> {
}
