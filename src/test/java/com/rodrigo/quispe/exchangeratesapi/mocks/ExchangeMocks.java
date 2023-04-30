package com.rodrigo.quispe.exchangeratesapi.mocks;

import com.rodrigo.quispe.exchangeratesapi.domain.RatesResponse;

import java.util.HashMap;
import java.util.Map;

public class ExchangeMocks {

    public static RatesResponse exchangeBOB() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("BOB", 10D);
        return new RatesResponse("USD", "2023", rates);
    }
}
