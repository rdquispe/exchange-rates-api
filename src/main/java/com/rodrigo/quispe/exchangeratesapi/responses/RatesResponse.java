package com.rodrigo.quispe.exchangeratesapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RatesResponse {

    @JsonProperty("base")
    public String base;

    @JsonProperty("date")
    public String date;

    @JsonProperty("rates")
    public Map<String, Double> rates;

    public RatesResponse() {

    }

    public RatesResponse(String base, String date, Map<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }
}
