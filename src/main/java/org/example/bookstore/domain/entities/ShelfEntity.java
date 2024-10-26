package org.example.bookstore.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shelfs")
public class ShelfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "shelf_id")
    private Long shelfId;

    @Column(name = "shelf_tiers_amount", nullable = false)
    private int shelfTiersAmount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "shelf_tiers")
    @ToString.Exclude
    private List<ShelfTierEntity> shelfTiers;
}
