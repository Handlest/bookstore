//package org.example.bookstore.domain.entities;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "book_positions")
//public class BookPositionEntity {
//    @Id
//    private Long positionId;
//
//    @Column(name = "shelf_number", nullable = false)
//    private Long shelfNumber;
//
//    @Column(name = "max_capacity", nullable = false)
//    private int maxCapacity;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @Builder.Default
//    private List<BookEntity> books = new ArrayList<>();
//
//    @Column(name = "current_capacity", nullable = false)
//    private int currentCapacity = books.size();
//
//    @PostUpdate
//    @PrePersist
//    public void postUpdatePrePersist() {
//        currentCapacity = books.size();
//    }
//}
