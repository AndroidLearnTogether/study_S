package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TestImpl implements Test {
    public String re() {
        return "HelloWorld!";
    }
}
