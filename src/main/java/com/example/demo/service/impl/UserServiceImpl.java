package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User get(String email) {
        return userMapper.getByEmail(email);
    }


    public User[] get() {
        return userMapper.get();
    }

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.register(user);
        return user.getEmail();
    }

    public String mather(User user) {
        User matherUser = userMapper.getByEmail(user.getEmail());
        if(matherUser == null) {
            return "email not match";
        }
        if(passwordEncoder.matches(user.getPassword(), matherUser.getPassword())) {
            return user.getEmail();
        } else {
            return "password not match";
        }
    }
}
