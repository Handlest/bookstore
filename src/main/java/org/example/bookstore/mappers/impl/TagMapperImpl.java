package org.example.bookstore.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.dto.TagDto;
import org.example.bookstore.domain.entities.TagEntity;
import org.example.bookstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagMapperImpl implements Mapper<TagEntity, TagDto> {

    private final ModelMapper modelMapper;

    @Override
    public TagDto mapToDto(TagEntity entity) {
        return modelMapper.map(entity, TagDto.class);
    }

    @Override
    public TagEntity mapFromDto(TagDto dto) {
        return modelMapper.map(dto, TagEntity.class);
    }
}

