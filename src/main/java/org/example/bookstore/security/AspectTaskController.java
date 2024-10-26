//package org.example.bookstore.security;
//
//import org.example.bookstore.domain.entities.UserEntity;
//import org.example.bookstore.services.UserService;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.client.HttpServerErrorException;
//
//@Aspect
//@RequiredArgsConstructor
//@AllArgsConstructor
//public class AspectTaskController {
//    private UserService userService;
//
//    @Before("execution(* org.example.bookstore.controllers.BookController.*(..))")
//    public void checkPrivilege() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        UserEntity user = userService.getByUsername(username)
//                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.FORBIDDEN));
//
//    }
//
//    @Before("greeting()")
//    public void beforeAdvice() {
//        System.out.print("Привет ");
//    }
//}
