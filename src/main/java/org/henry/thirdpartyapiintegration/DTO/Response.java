package org.henry.thirdpartyapiintegration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class Response {
    private String get;
    private List<Object> parameters;
    private List<Object> errors;
    private Integer results;
    private List<ResponseData> response;
}
