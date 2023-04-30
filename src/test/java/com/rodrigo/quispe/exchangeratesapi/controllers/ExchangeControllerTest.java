package com.rodrigo.quispe.exchangeratesapi.controllers;

import com.rodrigo.quispe.exchangeratesapi.mocks.ExchangeMocks;
import com.rodrigo.quispe.exchangeratesapi.application.ExchangeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
        when(exchangeService.latestRates()).thenReturn(ExchangeMocks.exchangeBOB());

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/latest"))
            .andExpect(jsonPath("$.base").value("USD"))
            .andExpect(jsonPath("$.date").value("2023"))
            .andExpect(jsonPath("$.rates.BOB").value("10.0"));
    }
}
