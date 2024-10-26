package org.example.bookstore.domain.requests.create;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.bookstore.domain.dto.*;
import org.example.bookstore.domain.entities.BookEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Запрос на добавление новой книги")
public class BookCreateRequest {
    @Schema(description = "Название книги", example = "Война и мир")
    @NotBlank(message = "Название книги не может быть пустым")
    @NotNull(message = "Название книги не может быть null")
    private String title;

    @Schema(description = "Описание книги", example = "Книга о великой трагедии царя Мидаса")
    private String description;

    @Schema(description = "Авторы книги")
    @NotNull(message = "Поле авторы не может быть null")
    @NotEmpty(message = "Поле авторы не может быть пустым")
    private List<String> authors;

    @Schema(description = "Язык книги", example = "RUS", defaultValue = "RUS")
    private BookEntity.BOOK_LANGUAGE language = BookEntity.BOOK_LANGUAGE.RUS;

    @Schema(description = "Дата публикации книги", example = "16-07-2020")
    @NotBlank(message = "Поле дата публикации не может быть пустым")
    @NotNull(message = "Поле дата публикации не может быть null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime publishDate;

    @Schema(description = "Издатель книги")
    @NotNull(message = "Поле издатель не может быть null")
    private String publisher;

    @Schema(description = "Жанры книги")
    @NotEmpty(message = "Поле авторы не может быть пустым")
    @NotNull(message = "Поле авторы не может быть null")
    private List<String> genres;

    @Schema(description = "Цена книги")
    @NotBlank(message = "Поле цена не может быть пустым")
    @NotNull(message = "Поле цена не может быть null")
    private Double price;

    @Schema(description = "ISBN книги")
    @NotBlank(message = "Поле isbn не может быть пустым")
    @NotNull(message = "Поле isbn не может быть null")
    private String isbn;

    @Schema(description = "Количество страниц книги")
    @NotBlank(message = "Поле количество страниц не может быть пустым")
    @NotNull(message = "Поле количество страниц не может быть null")
    private Integer pageAmount;

    @Schema(description = "Состояние книги", example = "NEW", defaultValue = "NEW")
    private BookEntity.BOOK_STATE state = BookEntity.BOOK_STATE.NEW;

    @Schema(description = "Теги книги")
    private List<String> tags;

    @Schema(description = "Стелаж, где расположена книга")
    @NotBlank(message = "Поле стелаж не может быть пустым")
    @NotNull(message = "Поле стелаж не может быть null")
    private ShelfDto shelf;

    @Schema(description = "Изображение обложки книги")
    private String bookCoverUrl;
}