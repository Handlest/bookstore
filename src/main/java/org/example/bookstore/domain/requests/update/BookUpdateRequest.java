package org.example.bookstore.domain.requests.update;
import lombok.Getter;
import lombok.Setter;
import org.example.bookstore.domain.dto.*;
import org.example.bookstore.domain.entities.BookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Запрос на обновление информации о    книге")
@Getter
@Setter
public class BookUpdateRequest {
    @Schema(description = "Id книги")
    private Long id;

    @Schema(description = "Название книги", example = "Война и мир")
    private String title;

    @Schema(description = "Описание книги", example = "Книга о великой трагедии царя Мидаса")
    private String description;

    @Schema(description = "Авторы книги")
    private List<String> authors;

    @Schema(description = "Язык книги", example = "RUS", defaultValue = "RUS")
    private BookEntity.BOOK_LANGUAGE language = BookEntity.BOOK_LANGUAGE.RUS;

    @Schema(description = "Дата публикации книги", example = "16-07-2020")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime publishDate;

    @Schema(description = "Издатель книги")
    private String publisher;

    @Schema(description = "Жанры книги")
    private List<String> genres;

    @Schema(description = "Цена книги")
    private Double price;

    @Schema(description = "ISBN книги")
    private String isbn;

    @Schema(description = "Количество страниц книги")
    private Integer pageAmount;

    @Schema(description = "Состояние книги", example = "NEW", defaultValue = "NEW")
    private BookEntity.BOOK_STATE state = BookEntity.BOOK_STATE.NEW;

    @Schema(description = "Теги книги")
    private List<String> tags;

    @Schema(description = "Стелаж, где расположена книга")
    private ShelfTierDto shelf;

    @Schema(description = "Изображение обложки книги")
    private String bookCoverUrl;
}