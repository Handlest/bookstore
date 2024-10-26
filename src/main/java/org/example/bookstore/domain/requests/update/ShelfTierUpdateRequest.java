package org.example.bookstore.domain.requests.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.bookstore.domain.entities.BookEntity;

import java.time.LocalDateTime;

@Data
@Schema(description = "Запрос на обновление информации о полке стелажа")
public class ShelfTierUpdateRequest {
    @Schema(description = "Максимальная вместимость полки (Сколько книг)", example = "15")
    private Integer shelfTiersAmount;

    @Schema(description = "Максимальная вместимость полки (Сколько книг)", example = "15")
    private Integer shelfTierNumber;
}