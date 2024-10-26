package org.example.bookstore.mappers.impl;

import org.example.bookstore.domain.dto.UserDto;
import org.example.bookstore.domain.entities.UserEntity;
import org.example.bookstore.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserDto mapToDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity mapFromDto(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
