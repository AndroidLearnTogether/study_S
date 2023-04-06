package com.example.demo.exception;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(GlobalException.class)
    protected ResponseEntity<ExceptionResponseDto> GlobalException(GlobalException e) {
        ExceptionResponseDto responseDto =
                ExceptionResponseDto
                        .builder()
                        .message(e.getMessage())
                        .status(e.getHttpstatus().value())
                        .error(e.getHttpstatus())
                        .build();
        return ResponseEntity.status(e.getHttpstatus())
                .body(responseDto);
    }
}
