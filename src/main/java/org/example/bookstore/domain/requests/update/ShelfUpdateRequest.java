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
@Schema(description = "Запрос на обновление информации о стелаже")
public class ShelfUpdateRequest {
    @Schema(description = "Количество полок на стелаже", example = "5")
    private Integer shelfTiersAmount;
}