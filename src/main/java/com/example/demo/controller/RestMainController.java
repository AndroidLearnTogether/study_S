package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/free")
@RequiredArgsConstructor
public class RestMainController {
    private final UserService userService;
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return userService.mather(user);
    }
    @PostMapping("/get")
    public User[] Test(@RequestParam(name = "email") String email){
        if(email.equals("")){
            return userService.get();
        }else{
            return new User[]{userService.get(email)};
        }
    }
}