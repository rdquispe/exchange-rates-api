package com.rodrigo.quispe.exchangeratesapi.infrastructure.controllers;

import com.rodrigo.quispe.exchangeratesapi.domain.UpResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping(value = "/health-check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(new UpResponse("up"));
    }
}
