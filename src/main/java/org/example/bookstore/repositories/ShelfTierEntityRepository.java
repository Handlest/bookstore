package org.example.bookstore.repositories;

import jakarta.transaction.Transactional;
import org.example.bookstore.domain.entities.ShelfTierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ShelfTierEntityRepository extends JpaRepository<ShelfTierEntity, Long> {
}