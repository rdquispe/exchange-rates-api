package com.rodrigo.quispe.exchangeratesapi.infrastructure.controllers;

import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;
import com.rodrigo.quispe.exchangeratesapi.application.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> latestRates() throws ApiException {
        return ResponseEntity.ok(exchangeService.latestRates());
    }

    @GetMapping(value = "/exchange/{from}/{amount}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> exchangeRates(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") double amount) throws ApiException {
        return ResponseEntity.ok(exchangeService.exchange(from, to, amount));
    }
}
