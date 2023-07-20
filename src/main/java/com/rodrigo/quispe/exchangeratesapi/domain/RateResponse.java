package com.rodrigo.quispe.exchangeratesapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class RateResponse {

    @JsonProperty("base")
    public String base;

    @JsonProperty("date")
    public String date;

    @JsonProperty("rates")
    public Map<String, Double> rates;

    public RateResponse() {

    }

    public RateResponse(String base, String date, Map<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }
}
