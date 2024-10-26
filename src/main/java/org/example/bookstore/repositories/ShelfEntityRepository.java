package org.example.bookstore.repositories;

import jakarta.transaction.Transactional;
import org.example.bookstore.domain.entities.ShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ShelfEntityRepository extends JpaRepository<ShelfEntity, Long> {
}