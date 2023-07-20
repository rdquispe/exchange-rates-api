package com.rodrigo.quispe.exchangeratesapi.mocks;

public class ExchangeMocks {

    public static String latestResponseOK() {
        return "{\"base\": \"USD\",\"date\": \"2023-07-15\",\"rates\": {\"BOB\": 6.90}}";
    }

    public static String rateResponseOK() {
        return "{ \"base\": \"USD\", \"date\": \"2023-07-15\", \"rates\": { \"BOB\": 6.904419, \"COP\": 4086, \"USD\": 1.0 } }";
    }
}
