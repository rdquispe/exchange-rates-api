package com.rodrigo.quispe.exchangeratesapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RatesResponse {

    @JsonProperty("base")
    public String base;

    @JsonProperty("date")
    public String date;

    @JsonProperty("rates")
    public HashMap<String, Double> rates;

    public RatesResponse() {

    }

    public RatesResponse(String base, String date, HashMap<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }
}
