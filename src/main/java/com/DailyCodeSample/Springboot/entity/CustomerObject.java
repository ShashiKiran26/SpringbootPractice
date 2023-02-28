package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@Data
public class CustomerObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CustomerId;
    @JsonProperty("application_date")
    private String application_date ;

    @JsonProperty("application_id")
    private String applicationid;

    @JsonProperty("amount")
    private float amount;

    @JsonProperty("system_status")
    private String system_status;

    @JsonProperty("system_sub_status")
    private String system_sub_status;
    @JsonProperty("applicant_name")
    private String applicant_name;

    @JsonProperty("mdm_stage")
    private String mdm_stage;

    @JsonProperty("mdm_product_code")
    private String mdm_product_code ;

    @JsonProperty("locations")
    private String locations;

    @JsonProperty("current_assignees")
    private List<String> current_assignees;

    @JsonProperty("mdm_source")
    private String mdm_source ;

    @JsonProperty("lending_partner_codes")
    private List<String> lending_partner_codes ;
}


