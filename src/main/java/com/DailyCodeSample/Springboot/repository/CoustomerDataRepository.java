package com.DailyCodeSample.Springboot.repository;

import com.DailyCodeSample.Springboot.entity.CustomerObject;
import com.DailyCodeSample.Springboot.entity.Customerdbh2object;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoustomerDataRepository extends JpaRepository<CustomerObject,Long> {
    public CustomerObject findByApplicationid(String id);

}
