package com.rodrigo.quispe.exchangeratesapi.application.handlers;

import com.rodrigo.quispe.exchangeratesapi.infrastructure.exceptions.ApiException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpHandler {

    private final OkHttpClient okHttpClient;

    @Autowired
    public HttpHandler(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public String getRates() throws ApiException {
        try (Response response = okHttpClient.newCall(getLatest()).execute()) {
            return response.body().string();
        } catch (IOException ex) {
            throw new ApiException("error_response", ex);
        }
    }

    private static Request getLatest() {
        return new Request.Builder()
            .get()
            .url("https://api.exchangerate.host/latest?base=USD")
            .build();
    }
}
