package com.web.spring_clubs.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E, D> {
    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOList(List<E> entities);

    List<E> toEntityList(List<D> dtos);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(D dto, @MappingTarget E entity);
}
