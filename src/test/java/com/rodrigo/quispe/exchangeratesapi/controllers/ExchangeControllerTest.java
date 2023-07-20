package com.rodrigo.quispe.exchangeratesapi.controllers;

import com.rodrigo.quispe.exchangeratesapi.application.handlers.HttpHandler;
import com.rodrigo.quispe.exchangeratesapi.mocks.ExchangeMocks;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HttpHandler httpHandler;

    @Test
    public void shouldSuccessLatestCall() throws Exception {
        when(httpHandler.getRates()).thenReturn(ExchangeMocks.latestResponseOK());

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/latest"))
            .andExpect(jsonPath("$.base").value("USD"))
            .andExpect(jsonPath("$.date").value("2023-07-15"))
            .andExpect(jsonPath("$.rates.BOB").value("6.9"));
    }

    @Test
    public void shouldSuccessExchangeCall() throws Exception {
        when(httpHandler.getRates()).thenReturn(ExchangeMocks.rateResponseOK());

        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/exchange/COP/50000/USD"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.USD").value(12.24));
    }
}
