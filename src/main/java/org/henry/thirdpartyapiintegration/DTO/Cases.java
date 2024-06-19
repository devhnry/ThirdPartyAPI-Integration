package org.henry.thirdpartyapiintegration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cases {
    @JsonProperty("new")
    private Integer newCase;
    private Integer active;
    private Integer critical;
    private Integer recovered;
    @JsonProperty("1M_pop")
    private String millionPopulation;
    private Integer total;

}
