package com.example.springlbd.controller;

import com.example.springlbd.services.NbpApiService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
@AllArgsConstructor
public class NbpApiController {

    private final NbpApiService nbpApiService;

    @GetMapping("/yesterday")
    public ResponseEntity<String> getYesterdayCurrenciesRates(){
        return nbpApiService.getYesterdayCurrenciesRates();
    }

    @GetMapping("/usd/10")
    public ResponseEntity<String> getLast10DaysUsdRates(){
        return nbpApiService.getLast10DaysUsdRates();
    }

}
