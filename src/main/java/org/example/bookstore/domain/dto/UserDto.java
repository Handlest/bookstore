package org.example.bookstore.domain.dto;

import org.example.bookstore.domain.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.example.bookstore.domain.entities.UserEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private UserEntity.Role role;
    @Schema(type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime registrationDateTime;
    private boolean isActive;
}