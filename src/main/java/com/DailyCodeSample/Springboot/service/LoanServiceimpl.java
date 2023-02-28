package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.entity.AcessTokenObject;
import com.DailyCodeSample.Springboot.entity.Loan;
import com.DailyCodeSample.Springboot.entity.PostJsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class LoanServiceimpl implements LoanService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AcessTokenObject getalldata(Loan employeedetails) {
        String url= "https://uat-dlp.ashvfinance.com/api/auth/users/login";

        HttpEntity<Loan> entity = new HttpEntity<Loan>(employeedetails,null);

        AcessTokenObject ss = restTemplate.exchange(url, HttpMethod.POST, entity, AcessTokenObject.class).getBody();

        return ss;
    }





}


