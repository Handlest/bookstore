package org.example.bookstore.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bookstore.domain.entities.ShelfTierBookPosition;

import java.util.List;

/**
 * DTO for {@link org.example.bookstore.domain.entities.ShelfTierEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShelfTierDto {
    private ShelfTierBookPosition shelfTier;
    private ShelfDto shelf;
    private int maxCapacity;
    private int currentCapacity;
    private List<BookDto> books;
}
