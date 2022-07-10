package com.example.springlbd.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class NbpApiService {

    private static final String RESOURCE_URL = "http://api.nbp.pl/api";
    private RestTemplate restTemplate;

    public NbpApiService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ResponseEntity<String> getYesterdayCurrenciesRates(){
        LocalDate date = LocalDate.now().minusDays(1);
        ResponseEntity<String> response = restTemplate.getForEntity(RESOURCE_URL+"/exchangerates/tables/a/"+date.toString() +"?format=json", String.class);
        return response;
    }

    public ResponseEntity<String> getLast10DaysUsdRates(){
        ResponseEntity<String> response = restTemplate.getForEntity(RESOURCE_URL+"/exchangerates/rates/a/usd/last/10/?format=json", String.class);
        return response;
    }

}
