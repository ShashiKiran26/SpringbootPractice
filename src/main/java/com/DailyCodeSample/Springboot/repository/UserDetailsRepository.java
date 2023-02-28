package com.DailyCodeSample.Springboot.repository;

import com.DailyCodeSample.Springboot.entity.CustomerObject;
import com.DailyCodeSample.Springboot.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

    public UserDetails findByUserId(String id);

}
