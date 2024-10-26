package org.example.bookstore.services.impl;

import org.example.bookstore.domain.requests.update.UserUpdateRequest;
import org.example.bookstore.domain.responses.UserGetCurrentUserResponse;
import org.example.bookstore.domain.responses.UserUpdateResponse;
import org.example.bookstore.domain.entities.UserEntity;
import org.example.bookstore.exceptions.EntityNotFoundException;
import org.example.bookstore.repositories.UserRepository;
import org.example.bookstore.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Contains logic for operations with User Entity
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserEntity create(UserEntity userEntity) {
        if (userRepository.existsByEmail(userEntity.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with " + userEntity.getEmail() + " email already exists");
        }
        return userRepository.save(userEntity);
    }


    @Override
    @Transactional
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity getById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Пользователь " + id + " не найден"));
    }

    @Override
    @Transactional
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь c email" + email + " не найден"));
    }

    @Override
    @Transactional
    public UserUpdateResponse update(long userId, UserUpdateRequest userUpdateRequest) {
        return userRepository.findById(userId).map(existingUserEntity -> {
            Optional.ofNullable(userUpdateRequest.getEmail()).ifPresent(existingUserEntity::setEmail);
            Optional.ofNullable(userUpdateRequest.getPassword()).ifPresent(pwd -> existingUserEntity.setPassword(passwordEncoder.encode(pwd)));
            userRepository.save(existingUserEntity);
            return UserUpdateResponse.builder()
                    .id(existingUserEntity.getUserId())
                    .role(existingUserEntity.getRole())
                    .email(existingUserEntity.getEmail())
                    .registrationDateTime(existingUserEntity.getRegistrationDateTime())
                    .build();
        }).orElseThrow(() -> new EntityNotFoundException("Пользователь " + userId + " не найден"));
    }

    @Override
    @Transactional
    public void deleteByEmail(String email){
        userRepository.deleteUserEntityByEmail(email);
    }

    @Override
    @Transactional
    public UserGetCurrentUserResponse getCurrentUser(UserEntity user) {
        return UserGetCurrentUserResponse.builder()
                .id(user.getUserId())
                .role(user.getRole())
                .email(user.getEmail())
                .registrationDateTime(user.getRegistrationDateTime()).build();
    }
}
