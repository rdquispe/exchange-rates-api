package com.rodrigo.quispe.exchangeratesapi.infrastructure.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping(value = "/health-check", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> health() {
        return Map.of("service", "up");
    }
}
