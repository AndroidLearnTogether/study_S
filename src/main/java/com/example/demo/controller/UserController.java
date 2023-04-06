package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @PostMapping("/test")
    public String test() throws IOException {
        throw new GlobalException(HttpStatus.I_AM_A_TEAPOT, "네놈의 서버는 터졌다!");
        //return "d";
    }
}
