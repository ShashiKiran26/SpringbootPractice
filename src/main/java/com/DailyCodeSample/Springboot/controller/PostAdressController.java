package com.DailyCodeSample.Springboot.controller;

import com.DailyCodeSample.Springboot.entity.PostJsonObject;
import com.DailyCodeSample.Springboot.service.PostaladressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostAdressController {

    @Autowired
    private PostaladressService Postal;

    @GetMapping(value="/bycityname/{cityname}" ,
            consumes = MediaType.ALL_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public PostJsonObject getadressbycityname(@PathVariable("cityname") String cityname){

        return Postal.getadressbycityname(cityname);

    }


}
