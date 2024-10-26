package org.example.bookstore.services;

import org.example.bookstore.domain.entities.ShelfEntity;
import org.example.bookstore.domain.requests.update.ShelfUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShelfService {
    ShelfEntity createShelf(ShelfEntity shelfEntity);

    ShelfEntity getShelfById(Long id);
    ShelfEntity getShelfByNumber(Integer number);
    List<ShelfEntity> getAllShelfs(Pageable pageable, Specification<ShelfEntity> specification);

    ShelfEntity updateShelf(ShelfUpdateRequest updateRequest);

    void deleteShelfByNumber(Integer number);
    void deleteShelfById(Long id);
}
