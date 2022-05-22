package com.rodrigo.quispe.exchangeratesapi.services;

import com.google.gson.Gson;
import com.rodrigo.quispe.exchangeratesapi.responses.RatesResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeService {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public RatesResponse latestRates() throws IOException {
        Request request = new Request.Builder()
            .get()
            .url("https://api.exchangerate.host/latest?base=USD")
            .build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), RatesResponse.class);
    }
}
