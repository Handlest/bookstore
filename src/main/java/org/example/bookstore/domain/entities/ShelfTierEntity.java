package org.example.bookstore.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shelf_tiers")
public class ShelfTierEntity {
    @EmbeddedId
    private ShelfTierBookPosition shelfTier;

    @ManyToOne
    @JoinColumn(name = "shelf", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ToString.Exclude
    private ShelfEntity shelf;

    @Column(name = "max_capacity", nullable = false)
    private int maxCapacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<BookEntity> books = new ArrayList<>();

    @Column(name = "current_capacity", nullable = false)
    private int currentCapacity = books.size();

    @PostUpdate
    @PrePersist
    public void postUpdatePrePersist() {
        currentCapacity = books.size();
    }
}
