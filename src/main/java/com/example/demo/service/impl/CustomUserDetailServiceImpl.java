package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.domain.UserForSecurity;
import com.example.demo.service.CustomUserDetailService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.get(username);
        return UserForSecurity
                .builder()
                .user(user)
                .build();
    }
}
