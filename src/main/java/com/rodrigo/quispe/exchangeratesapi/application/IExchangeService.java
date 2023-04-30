package com.rodrigo.quispe.exchangeratesapi.application;

import com.rodrigo.quispe.exchangeratesapi.domain.RatesResponse;
import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;

import java.util.Map;

public interface IExchangeService {

    RatesResponse latestRates() throws ApiException;

    Map<String, Object> exchange(String from, String to, double amount) throws ApiException;
}
