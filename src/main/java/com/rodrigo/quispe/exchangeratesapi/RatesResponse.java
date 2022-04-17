package com.rodrigo.quispe.exchangeratesapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class RatesResponse {

    @JsonProperty("base")
    String base;

    @JsonProperty("date")
    String date;

    @JsonProperty("rates")
    HashMap<String, Object> rates;

    public RatesResponse() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public RatesResponse(String base, String date) {
        this.base = base;
        this.date = date;
    }

    public RatesResponse(String base, String date, HashMap<String, Object> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public void setRates(HashMap<String, Object> rates) {
        this.rates = rates;
    }
}
