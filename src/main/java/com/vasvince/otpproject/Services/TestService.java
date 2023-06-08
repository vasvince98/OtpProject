package com.vasvince.otpproject.Services;

import com.vasvince.otpproject.Entities.TestEntity;
import com.vasvince.otpproject.Repositories.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class TestService {

    private final ITestRepository testRepository;

    @Autowired
    public TestService(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void addNumber(int number) {
        testRepository.save(new TestEntity("Testname", number, LocalDateTime.now()));
    }

    @Transactional
    public void deleteNumber(int number) {
        testRepository.deleteByNumber(number);
    }

}
