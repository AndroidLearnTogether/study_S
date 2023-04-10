package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SonClass implements Son, Tes {
    @Override
    public String re() {
        return "x";
    }
}
