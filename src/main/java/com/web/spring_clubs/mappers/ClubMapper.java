package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.dtos.ClubDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper extends GenericMapper<Club, ClubDTO> {
}
