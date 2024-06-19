package org.henry.thirdpartyapiintegration.controller;


import org.henry.thirdpartyapiintegration.Service.impl.CovidServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CovidController {

    private CovidServiceImpl covidService;

    public CovidController(CovidServiceImpl covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/countries")
    public Object getAllCountries(){
        return covidService.getAllCountries();
    }

    @GetMapping("/statistics")
    public Object getAllStats(){
        return covidService.getAllStatistics();
    }
}
