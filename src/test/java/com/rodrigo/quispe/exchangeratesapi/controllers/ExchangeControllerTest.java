package com.rodrigo.quispe.exchangeratesapi.controllers;

import com.rodrigo.quispe.exchangeratesapi.responses.RatesResponse;
import com.rodrigo.quispe.exchangeratesapi.services.ExchangeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeService exchangeService;

    @Test
    public void shouldSuccessExchangeLatestCall() throws Exception {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("BOB", 10D);

        var response = new RatesResponse("USD", "2022", rates);
        when(exchangeService.latestRates()).thenReturn(response);

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/latest"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("{\"base\":\"USD\",\"date\":\"2022\",\"rates\":{\"BOB\":10.0}}")));
    }
}
