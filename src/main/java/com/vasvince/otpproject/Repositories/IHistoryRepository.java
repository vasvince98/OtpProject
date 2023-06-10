package com.vasvince.otpproject.Repositories;

import com.vasvince.otpproject.Entities.History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHistoryRepository extends CrudRepository<History, Integer> {

    List<History> findAll();

}
