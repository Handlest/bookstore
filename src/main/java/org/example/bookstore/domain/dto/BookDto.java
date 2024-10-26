package org.example.bookstore.domain.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bookstore.domain.entities.BookEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link org.example.bookstore.domain.entities.BookEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private long bookId;
    private String title;
    private String description;
    private List<String> authors;
    private BookEntity.BOOK_LANGUAGE language;
    @Schema(type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime publishedDate;
    private String publisher;
    private List<String> genres;
    private double price;
    private String isbn;
    private int pageAmount;
    private BookEntity.BOOK_STATE bookState;
    private List<String> tags;
    private ShelfTierDto shelfTier;
    private String coverImageUrl;
    private long createdByUserId;
    @Schema(type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime addedDateTime;
}
