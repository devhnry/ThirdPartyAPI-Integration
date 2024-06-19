package org.henry.thirdpartyapiintegration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {
    private String continent;
    private String country;
    private Integer population;
    private Cases cases;
    private Deaths deaths;
    private Tests tests;
    private String day;
    private String time;
}
