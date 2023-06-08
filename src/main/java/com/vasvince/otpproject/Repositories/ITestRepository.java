package com.vasvince.otpproject.Repositories;

import com.vasvince.otpproject.Entities.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITestRepository extends CrudRepository<TestEntity, Integer> {

    void deleteByNumber(int number);

}
