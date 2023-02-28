package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customerdbh2object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CustomerId;
    private String application_date ;
    private String applicationid;
    private float amount;

    private String system_status;

    private String system_sub_status;

    private String applicant_name;

    private String mdm_stage;

    private String mdm_product_code ;

    private String locations;

    private List<String> current_assignees;

    private String mdm_source ;

    private List<String> lending_partner_codes ;
}
