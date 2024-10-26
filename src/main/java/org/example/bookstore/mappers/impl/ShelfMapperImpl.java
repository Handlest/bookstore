package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.ShelfDto;
import org.example.bookstore.domain.entities.ShelfEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShelfMapperImpl implements Mapper<ShelfEntity, ShelfDto> {

    private final ModelMapper modelMapper;

    @Override
    public ShelfDto mapToDto(ShelfEntity entity) {
        return modelMapper.map(entity, ShelfDto.class);
    }

    @Override
    public ShelfEntity mapFromDto(ShelfDto dto) {
        return modelMapper.map(dto, ShelfEntity.class);
    }
}

