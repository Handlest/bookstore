package org.example.bookstore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition (info = @Info(
        title = "Books management system API",
        description = "Made by students of 8K14 group", version = "0.0.1",
        contact = @Contact(
                name = "Михалёв Максим",
                url = "https://t.me/Handlest"
        )
    )
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer")
public class OpenApiConfig {

}