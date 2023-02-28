package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListOfKeyObjects {
    private List<KeyObject> keyObjectList;
}
