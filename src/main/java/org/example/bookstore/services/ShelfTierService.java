package org.example.bookstore.services;

import org.example.bookstore.domain.entities.ShelfTierEntity;
import org.example.bookstore.domain.requests.update.ShelfTierUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShelfTierService {
    ShelfTierEntity createShelfTier(ShelfTierEntity ShelfTierEntity);

    ShelfTierEntity getShelfTierById(Long id);
    ShelfTierEntity getShelfTierByNumber(Integer number);
    List<ShelfTierEntity> getAllShelfTiers(Pageable pageable, Specification<ShelfTierEntity> specification);

    ShelfTierEntity updateShelfTier(ShelfTierUpdateRequest shelfTierUpdateRequest);

    void deleteShelfTierByNumber(Integer number);
    void deleteShelfTierById(Long id);
}
