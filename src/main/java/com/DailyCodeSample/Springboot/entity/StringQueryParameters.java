package com.DailyCodeSample.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StringQueryParameters {
    @JsonProperty("page")
    private String page;
    @JsonProperty("size")
    private String size;

}
