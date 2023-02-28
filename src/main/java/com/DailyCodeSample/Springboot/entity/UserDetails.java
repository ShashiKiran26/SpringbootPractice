package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @JsonProperty("first_name")
    private String firstName ;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("username")
    private String userName ;

    @JsonProperty("last_name")
    private String lastName ;

//    @JsonProperty("roles")
//    private List<String> roles;
}
