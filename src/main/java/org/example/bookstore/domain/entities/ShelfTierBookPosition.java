package org.example.bookstore.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShelfTierBookPosition implements Serializable {
    private int tier;
    private int shelfNumber;
}
