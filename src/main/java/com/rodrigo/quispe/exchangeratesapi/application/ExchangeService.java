package com.rodrigo.quispe.exchangeratesapi.application;

import com.google.gson.Gson;
import com.rodrigo.quispe.exchangeratesapi.application.handlers.HttpHandler;
import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;
import com.rodrigo.quispe.exchangeratesapi.domain.RateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService implements IExchangeService {

    private final Gson gson;
    private final HttpHandler httpHandler;
    private final Logger logger = LoggerFactory.getLogger(ExchangeService.class);

    public ExchangeService(Gson gson, HttpHandler httpHandler) {
        this.gson = gson;
        this.httpHandler = httpHandler;
    }

    @Override
    public RateResponse latestRates() throws ApiException {
        String response = httpHandler.getRates();

        return gson.fromJson(response, RateResponse.class);
    }

    @Override
    public Map<String, Object> exchange(String from, String to, double amount) throws ApiException {

        if (amount <= 0) throw new ApiException("invalid_amount");

        String response = httpHandler.getRates();

        RateResponse rateResponse = gson.fromJson(response, RateResponse.class);

        Double usd = amount / rateResponse.rates.get(from);
        Double toCurrency = usd * rateResponse.rates.get(to);

        Map<String, Object> payload = new HashMap<>();
        payload.put("USD", usd);
        payload.put(to, roundAmount(toCurrency));

        return payload;
    }

    private String roundAmount(Double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        
        return decimalFormat.format(amount);
    }
}
