package com.vasvince.otpproject.Controllers;


import com.vasvince.otpproject.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    private final TestService testService;

    @Autowired
    public RestTestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String test(@RequestParam int number) {
        return testService.test(number);
    }
}
