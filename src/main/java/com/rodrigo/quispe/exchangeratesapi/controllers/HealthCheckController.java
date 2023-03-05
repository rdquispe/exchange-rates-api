package com.rodrigo.quispe.exchangeratesapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping(value = "/health-check", produces = {"application/json"})
    public Map<String, Object> ping() {
        Map<String, Object> pong = new HashMap<>();
        pong.put("service", "up");

        return pong;
    }
}
