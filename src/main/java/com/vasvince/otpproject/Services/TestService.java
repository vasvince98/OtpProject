package com.vasvince.otpproject.Services;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test(int number) {
        return "Test number: " + number;
    }
}
