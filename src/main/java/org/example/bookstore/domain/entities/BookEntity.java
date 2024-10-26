package org.example.bookstore.domain.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
public class BookEntity {
    public enum BOOK_LANGUAGE {RUS, ENG, OTHER}
    public enum BOOK_STATE {NEW, USED}

    @Id
    @SequenceGenerator(name = "tasks_seq", sequenceName = "tasks_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @ElementCollection
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "authors")
    private List<String> authors = new ArrayList<>();

    @Column(name = "book_language", nullable = false)
    @Builder.Default
    private BOOK_LANGUAGE language = BOOK_LANGUAGE.RUS;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false, name = "published_date")
    private LocalDateTime publishedDate;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @ElementCollection
    @CollectionTable(name = "book_genres", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "genre")
    private List<String> genres = new ArrayList<>();

    @Column(nullable = true)
    private double price;

    @Column(nullable = true, unique = true)
    private String isbn;

    @Column(name = "page_amount", nullable = false)
    private int pageAmount;

    @Column(name = "book_state", nullable = false)
    @Builder.Default
    private BOOK_STATE bookState = BOOK_STATE.NEW;

    @ElementCollection
    @CollectionTable(name = "book_tags", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "tags")
    List<String> tags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "shelf_tier_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShelfTierEntity shelfTier;

    @Lob // represents as BLOB
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture")
    @ToString.Exclude
    private byte[] coverPicture;

    @ManyToOne
    @JoinColumn(name = "added_by_user_id", nullable = false, insertable = true, updatable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private UserEntity addedByUser;

    @Column(name = "added_date_time", nullable = false, insertable = true, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime addedDateTime;
}
