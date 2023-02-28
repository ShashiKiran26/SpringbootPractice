package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}

