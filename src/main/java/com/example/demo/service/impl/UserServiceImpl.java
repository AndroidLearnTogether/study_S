package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public User[] get(String email) {
        return userMapper.getByEmail(email);
    }


    public User[] get() {
        return userMapper.get();
    }

    public String register(User user) {
        userMapper.register(user);
        return user.getEmail();
    }
}
