package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.controller.DepartmentController;
import com.DailyCodeSample.Springboot.entity.PostJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Postaladressimpl implements PostaladressService {

    @Autowired
    RestTemplate restTemplate;

    private final Logger LOGGER= LoggerFactory.getLogger(Postaladressimpl.class);


    @Override
    public PostJsonObject getadressbycityname(String cityname) {
        String Url= "https://api.postalpincode.in/postoffice/"+ cityname;
        LOGGER.info("Hey I am Logger1 from ServiceImplementationPost class");

        ResponseEntity<PostJsonObject[]> postalResponse= restTemplate.getForEntity(Url,PostJsonObject[].class);

        LOGGER.info("Hey I am Logger2 from ServiceImplementationPost class");
        return postalResponse.getBody()[0];
    }
}
