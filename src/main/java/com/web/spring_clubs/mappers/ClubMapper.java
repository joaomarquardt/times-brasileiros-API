package com.web.spring_clubs.mappers;

import com.web.spring_clubs.domain.Club;
import com.web.spring_clubs.dtos.ClubDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);

    ClubDTO toDTO(Club entity);

    Club toEntity(ClubDTO dto);

    List<ClubDTO> toDTOList(List<Club> entities);

    List<Club> toEntityList(List<ClubDTO> dtos);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ClubDTO dto, @MappingTarget Club entity);
}
