package com.DailyCodeSample.Springboot.entity;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.catalina.LifecycleState;

public class PostJsonObject {

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Status")
    private String Status;

    @JsonProperty("PostOffice")
    private List<PostOffices> PostOffice;
}


