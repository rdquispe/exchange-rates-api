package com.rodrigo.quispe.exchangeratesapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class RatesResponse {

    @JsonProperty("base")
    String base;

    @JsonProperty("date")
    String date;

    @JsonProperty("rates")
    HashMap<String, BigDecimal> rates;

    public RatesResponse() {

    }

    public RatesResponse(String base, String date, HashMap<String, BigDecimal> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }
}
