package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private final HttpStatus httpstatus;
    private String message;
}