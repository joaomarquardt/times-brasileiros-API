package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Coach;
import com.web.spring_clubs.dtos.CoachDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoachMapper {
    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);

    CoachDTO toDTO(Coach entity);

    Coach toEntity(CoachDTO dto);

    List<CoachDTO> toDTOList(List<Coach> entities);

    List<Coach> toEntityList(List<CoachDTO> dtos);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(CoachDTO dto, @MappingTarget Coach entity);
}
