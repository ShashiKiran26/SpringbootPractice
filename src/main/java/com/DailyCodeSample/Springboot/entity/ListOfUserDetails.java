package com.DailyCodeSample.Springboot.entity;

import lombok.Data;

import java.util.List;

@Data

public class ListOfUserDetails {

    private List<UserDetails> userDetailsList;
}
