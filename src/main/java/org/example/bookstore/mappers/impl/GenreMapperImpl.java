package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.GenreDto;
import org.example.bookstore.domain.entities.GenreEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreMapperImpl implements Mapper<GenreEntity, GenreDto> {

    private final ModelMapper modelMapper;

    @Override
    public GenreDto mapToDto(GenreEntity genreEntity) {
        return modelMapper.map(genreEntity, GenreDto.class);
    }

    @Override
    public GenreEntity mapFromDto(GenreDto genreDto) {
        return modelMapper.map(genreDto, GenreEntity.class);
    }
}

