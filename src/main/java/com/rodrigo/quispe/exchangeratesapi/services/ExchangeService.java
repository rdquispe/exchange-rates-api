package com.rodrigo.quispe.exchangeratesapi.services;

import com.google.gson.Gson;
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
    private final Gson gson = new Gson();

    @Autowired
    private OkHttpClient okHttpClient;

    public RatesResponse latestRates() throws IOException {
        Response response = okHttpClient.newCall(getLatest()).execute();
        RatesResponse ratesResponse = gson.fromJson(response.body().string(), RatesResponse.class);

        logger.info(response.toString());

        return ratesResponse;
    }

    public Map exchange(String from, String to, double amount) {
        Map responseMap = new HashMap<String, Object>();

        try {
            Response response = okHttpClient.newCall(getLatest()).execute();
            RatesResponse ratesResponse = gson.fromJson(response.body().string(), RatesResponse.class);
            Double usd = amount / ratesResponse.rates.get(from);
            Double toCurrency = usd * ratesResponse.rates.get(to);

            responseMap.put("USD", usd);
            responseMap.put(to, toCurrency);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return responseMap;
    }

    private Request getLatest() {
        return new Request.Builder()
            .get()
            .url("https://api.exchangerate.host/latest?base=USD")
            .build();
    }
}
