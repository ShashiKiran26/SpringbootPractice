package com.DailyCodeSample.Springboot.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostOffices {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("BranchType")
    private String BranchType;

    @JsonProperty("DeliveryStatus")
    private String DeliveryStatus;

    @JsonProperty("Circle")
    private String Circle;

    @JsonProperty("District")
    private String District;

    @JsonProperty("Division")
    private String Division;

    @JsonProperty("Region")
    private String Region;

    @JsonProperty("State")
    private String State;

    @JsonProperty("Country")
    private String Country;


}

