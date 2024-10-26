package org.example.bookstore.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/shelf")
@RequiredArgsConstructor
@Validated
@Tag(name = "Работа со стелажами")
public class ShelfController {
}
