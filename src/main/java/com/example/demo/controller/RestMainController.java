package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestMainController {
    private final UserService userService;
    @PostMapping("/test")
    public String Test(@RequestBody User user){

        return userService.register(user);
    }
    @PostMapping("/get")
    public User[] Test(@RequestParam(name = "email") String email){
        if(email.equals("")){
            return userService.get();
        }else{
            return userService.get(email);
        }


    }
}
