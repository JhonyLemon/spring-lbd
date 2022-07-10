package com.example.springlbd.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class NbpApiController {

    private static final String RESOURCE_URL = "http://api.nbp.pl/api";
    private RestTemplate restTemplate;

    public NbpApiController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/yesterday")
    public ResponseEntity<String> getYesterdayCurrenciesRates(){
        LocalDate date = LocalDate.now().minusDays(1);
        ResponseEntity<String> response = restTemplate.getForEntity(RESOURCE_URL+"/exchangerates/tables/a/"+date.toString() +"?format=json", String.class);
        return response;
    }

    @GetMapping("/usd/10")
    public ResponseEntity<String> getLast10DaysUsdRates(){
        ResponseEntity<String> response = restTemplate.getForEntity(RESOURCE_URL+"/exchangerates/rates/a/usd/last/10/?format=json", String.class);
        return response;
    }

}
