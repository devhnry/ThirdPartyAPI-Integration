package org.henry.thirdpartyapiintegration.Service.impl;

import lombok.extern.slf4j.Slf4j;
import org.henry.thirdpartyapiintegration.DTO.Response;
import org.henry.thirdpartyapiintegration.DTO.ResponseData;
import org.henry.thirdpartyapiintegration.DTO.UserResponse;
import org.henry.thirdpartyapiintegration.Service.CovidService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class CovidServiceImpl implements CovidService {

    private static final String URL = "https://covid-193.p.rapidapi.com/";
    private static final String xRapidApiKey = "59f3504095msh19faa8635fd24c6p1b2bddjsn127437881b2d";
    private static final String xRapidApiHost = "covid-193.p.rapidapi.com";

    private RestTemplate restTemplate;

    private CovidServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Object getAllCountries(){
        try{
            HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());

            String url = URL + "countries";
            System.out.println(url);
            var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
            log.info("It worked..");

            return response.getBody();
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("Something went wrong");
            throw new
                    ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching api for Covid");
        }
    }

    @Override
    public Object getAllStatistics(){
        try{
            HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());

            String url = URL + "statistics";
            System.out.println(url);
            var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Response.class);
            log.info("It worked..");

            Response res = response.getBody();

            UserResponse userResponse = new UserResponse();
            List<ResponseData> newData = new ArrayList<>();

            Consumer<ResponseData> convertData = resp -> {
                ResponseData responseData = new ResponseData();

                responseData.setContinent(resp.getContinent());
                responseData.setCountry(resp.getCountry());
                responseData.setDay(resp.getDay());
                responseData.setTime(resp.getTime());
                responseData.setPopulation(resp.getPopulation());

                newData.add(responseData);
            };
            res.getResponse().forEach(convertData);

            userResponse.setResponse(newData);
            return userResponse;
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("Something went wrong");
            throw new
                    ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching api for Covid");
        }
    }

    private HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", xRapidApiKey);
        headers.set("X-RapidAPI-Host", xRapidApiHost);
        return headers;
    }
}
