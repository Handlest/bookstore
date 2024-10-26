package org.example.bookstore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO for {@link org.example.bookstore.domain.entities.ShelfEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShelfDto {
    private Long shelfId;
    private int shelfTiersAmount;
    private List<ShelfTierDto> shelfTiers;
}
