package com.rodrigo.quispe.exchangeratesapi.controllers;

import com.rodrigo.quispe.exchangeratesapi.responses.RatesResponse;
import com.rodrigo.quispe.exchangeratesapi.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping(value = "/latest", produces = {"application/json"})
    public RatesResponse latestRates() throws IOException {
        return exchangeService.latestRates();
    }

    @GetMapping(value = "/exchange/{from}/{amount}/{to}", produces = {"application/json"})
    public Map exchangeRates(
        @PathVariable("from") String from,
        @PathVariable("to") String to,
        @PathVariable("amount") double amount
    ) {
        return exchangeService.exchange(from, to, amount);
    }
}
