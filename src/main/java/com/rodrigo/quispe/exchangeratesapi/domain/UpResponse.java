package com.rodrigo.quispe.exchangeratesapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpResponse {

    @JsonProperty("service")
    private String service;

    public UpResponse(String service) {
        this.service = service;
    }
}
