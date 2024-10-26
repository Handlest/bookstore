package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.ShelfTierDto;
import org.example.bookstore.domain.entities.ShelfTierEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShelfTierMapperImpl implements Mapper<ShelfTierEntity, ShelfTierDto> {

    private final ModelMapper modelMapper;

    @Override
    public ShelfTierDto mapToDto(ShelfTierEntity entity) {
        return modelMapper.map(entity, ShelfTierDto.class);
    }

    @Override
    public ShelfTierEntity mapFromDto(ShelfTierDto dto) {
        return modelMapper.map(dto, ShelfTierEntity.class);
    }
}

