package com.rodrigo.quispe.exchangeratesapi.application;

import com.rodrigo.quispe.exchangeratesapi.domain.RateResponse;
import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;

import java.util.Map;

public interface IExchangeService {

    RateResponse latestRates() throws ApiException;

    Map<String, Object> exchange(String from, String to, double amount) throws ApiException;
}
