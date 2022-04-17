package com.rodrigo.quispe.exchangeratesapi;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping
public class ExchangeController {

    private final String URL = "https://api.exchangerate.host/latest?base=USD";

    @GetMapping(value = "/latest", produces = {"application/json"})
    public RatesResponse latestRates() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        Request request = new Request.Builder()
            .get()
            .url(URL)
            .build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), RatesResponse.class);
    }
}
