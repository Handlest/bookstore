package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.AuthorDto;
import org.example.bookstore.domain.entities.AuthorEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    private final ModelMapper modelMapper;

    @Override
    public AuthorDto mapToDto(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFromDto(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}

