package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.Son;
import com.example.demo.service.SonClass;
import com.example.demo.service.UserService;
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
