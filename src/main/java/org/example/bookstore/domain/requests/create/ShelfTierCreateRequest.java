package org.example.bookstore.domain.requests.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Запрос на добавление новой полки на стелаже")
public class ShelfTierCreateRequest {
    @Schema(description = "Максимальная вместимость полки (Сколько книг)", example = "15")
    @NotBlank(message = "Поле количество полок не может быть пустым")
    @NotNull(message = "Поле количество полок не может быть null")
    private Integer shelfTiersAmount;

    @Schema(description = "Максимальная вместимость полки (Сколько книг)", example = "15")
    @NotBlank(message = "Поле количество полок не может быть пустым")
    @NotNull(message = "Поле количество полок не может быть null")
    private Integer shelfTierNumber;
}

