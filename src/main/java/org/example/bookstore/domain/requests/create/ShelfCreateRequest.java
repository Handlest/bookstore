package org.example.bookstore.domain.requests.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Запрос на добавление нового стелажа для книг")
public class ShelfCreateRequest {
    @Schema(description = "Количество полок на стелаже", example = "5")
    @NotBlank(message = "Поле количество полок не может быть пустым")
    @NotNull(message = "Поле количество полок не может быть null")
    private Integer shelfTiersAmount;
}
