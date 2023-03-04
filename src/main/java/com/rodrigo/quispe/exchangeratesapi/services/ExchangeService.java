package com.rodrigo.quispe.exchangeratesapi.services;

import com.google.gson.Gson;
import com.rodrigo.quispe.exchangeratesapi.exceptions.ApiException;
import com.rodrigo.quispe.exchangeratesapi.responses.RatesResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Gson gson;
    private final OkHttpClient okHttpClient;

    @Autowired
    public ExchangeService(OkHttpClient okHttpClient, Gson gson) {
        this.okHttpClient = okHttpClient;
        this.gson = gson;
    }

    public RatesResponse latestRates() throws ApiException {
        RatesResponse ratesResponse = null;
        try {
            Response response = okHttpClient.newCall(getLatest()).execute();
            ratesResponse = gson.fromJson(response.body().string(), RatesResponse.class);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            throw new ApiException(ex);
        }

        return ratesResponse;
    }

    public Map<String, Object> exchange(String from, String to, double amount) throws ApiException {
        Map<String, Object> map = new HashMap<>();

        try {
            Response response = okHttpClient.newCall(getLatest()).execute();
            RatesResponse ratesResponse = gson.fromJson(response.body().string(), RatesResponse.class);
            Double usd = amount / ratesResponse.rates.get(from);
            Double toCurrency = usd * ratesResponse.rates.get(to);

            map.put("USD", usd);
            map.put(to, toCurrency);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            throw new ApiException(ex);
        }

        return map;
    }

    private Request getLatest() {
        return new Request.Builder()
            .get()
            .url("https://api.exchangerate.host/latest?base=USD")
            .build();
    }
}
