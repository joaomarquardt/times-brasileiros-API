package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.dtos.CoachDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoachMapper extends GenericMapper<Coach, CoachDTO> {
}
