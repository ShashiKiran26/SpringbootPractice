package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

@Data
@JsonIgnoreProperties
public class AcessTokenObject {
    @JsonProperty("access_token")
    private String access_token;
//    @JsonProperty("refresh_token")
//    private String refresh_token;
//    @JsonProperty("expires_in")
//    private Long expires_in;
//    @JsonProperty("refresh_expires_in")
//    private Long  refresh_expires_in;
//    @JsonProperty("token_type")
//    private String token_type;
}
