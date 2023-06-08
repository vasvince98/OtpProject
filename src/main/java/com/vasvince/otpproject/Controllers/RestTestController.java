package com.vasvince.otpproject.Controllers;


import com.vasvince.otpproject.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestTestController {

    private final TestService testService;

    @Autowired
    public RestTestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/")
    public void addNumber(@RequestParam int number) {
        testService.addNumber(number);
    }

    @DeleteMapping("/")
    public void deleteNumber(@RequestParam int number) {
        testService.deleteNumber(number);
    }
}
