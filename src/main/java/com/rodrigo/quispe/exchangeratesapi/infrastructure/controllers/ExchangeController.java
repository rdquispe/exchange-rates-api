package com.rodrigo.quispe.exchangeratesapi.infrastructure.controllers;

import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;
import com.rodrigo.quispe.exchangeratesapi.domain.RatesResponse;
import com.rodrigo.quispe.exchangeratesapi.application.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public RatesResponse latestRates() throws ApiException {
        return exchangeService.latestRates();
    }

    @GetMapping(value = "/exchange/{from}/{amount}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> exchangeRates(
        @PathVariable("from") String from,
        @PathVariable("to") String to,
        @PathVariable("amount") double amount
    ) throws ApiException {
        return exchangeService.exchange(from, to, amount);
    }
}
