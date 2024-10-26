package org.example.bookstore.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.bookstore.domain.requests.UserRefreshTokenRequest;
import org.example.bookstore.domain.requests.UserSignInRequest;
import org.example.bookstore.domain.requests.UserSignUpRequest;
import org.example.bookstore.domain.responses.UserJwtAuthenticationResponse;
import org.example.bookstore.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Авторизация и аутентификация")
public class AuthenticationController {
    private final AuthenticationService service;

    @Operation(summary = "Зарегистрировать пользователя и получить JWT токены")
    @PostMapping("/register")
    public ResponseEntity<UserJwtAuthenticationResponse> register(@RequestBody @Validated UserSignUpRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Аутентифицировать зарегистрированного пользователя и получить JWT токены")
    @PostMapping("/authenticate")
    public ResponseEntity<UserJwtAuthenticationResponse> authenticate(@RequestBody @Validated UserSignInRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @Operation(summary = "Выпустить новую пару токенов с помощью refresh токена")
    @PostMapping("/refresh-token")
    public ResponseEntity<UserJwtAuthenticationResponse> refreshToken(@RequestBody @Validated UserRefreshTokenRequest request){
        return ResponseEntity.ok(service.refreshToken(request));
    }
}