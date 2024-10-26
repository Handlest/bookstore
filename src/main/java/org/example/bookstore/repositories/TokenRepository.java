package org.example.bookstore.repositories;

import jakarta.transaction.Transactional;
import org.example.bookstore.domain.entities.TokenRedisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TokenRepository extends CrudRepository<TokenRedisEntity, String> {

    Optional<TokenRedisEntity> getByToken(String token);
    void deleteAllByUserId(String userId);
    void deleteByToken(String token);
}