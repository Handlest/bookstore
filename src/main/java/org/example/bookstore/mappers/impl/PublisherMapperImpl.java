package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.PublisherDto;
import org.example.bookstore.domain.entities.PublisherEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherMapperImpl implements Mapper<PublisherEntity, PublisherDto> {

    private final ModelMapper modelMapper;

    @Override
    public PublisherDto mapToDto(PublisherEntity entity) {
        return modelMapper.map(entity, PublisherDto.class);
    }

    @Override
    public PublisherEntity mapFromDto(PublisherDto dto) {
        return modelMapper.map(dto, PublisherEntity.class);
    }
}

