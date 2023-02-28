package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListofCustomers {

    @JsonProperty("data")
    private List<CustomerObject> data;

    public List<CustomerObject> getData() {
        return data;
    }
}
