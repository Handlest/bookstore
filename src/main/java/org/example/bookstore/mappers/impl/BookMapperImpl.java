package org.example.bookstore.mappers.impl;

import org.example.bookstore.domain.dto.BookDto;
import org.example.bookstore.domain.entities.BookEntity;
import org.example.bookstore.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {

    private final ModelMapper modelMapper;

    @Override
    public BookDto mapToDto(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapFromDto(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
}

