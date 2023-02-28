package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.entity.PostJsonObject;

public interface PostaladressService {
    PostJsonObject getadressbycityname(String cityname);
}
