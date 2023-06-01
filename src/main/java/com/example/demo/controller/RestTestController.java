package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RestTestController {
    private final SonClass son;
    @PostMapping("/test")
    public String test() {
        return son.re();
    }
}
