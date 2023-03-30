package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    public String register(User user);

    public User[] get(String email);
    public User[] get();
}
