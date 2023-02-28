package com.DailyCodeSample.Springboot.repository;

import com.DailyCodeSample.Springboot.entity.Customerdbh2object;
import com.DailyCodeSample.Springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customerdbh2object,Long> {

    public Customerdbh2object findByApplicationid(String id);

}
