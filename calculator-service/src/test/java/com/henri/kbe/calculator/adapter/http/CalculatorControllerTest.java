package com.henri.kbe.calculator.adapter.http;

import com.henri.kbe.CalculatorApplication;
import com.henri.kbe.calculator.domain.CalculatorService;
import com.henri.kbe.calculator.domain.TaxCalculator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {CalculatorApplication.class, CalculatorService.class, TaxCalculator.class})
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetRequestToCalculatorAndValidPrice_ThenCorrectResponse() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/rest/calculator/2.99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.tax", is(0.5681)));
    }

    @Test
    public void whenGetRequestToCalculatorAndInvalidPath_ThenStatus404() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/rest/calculator/notAPrice")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    public void whenPostRequestToCalculator_ThenStatus405() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/rest/calculator/2.99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(405));
    }

    @Test
    public void whenPriceIsNegative_ThenStatus405() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/rest/calculator/-5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(405));
    }

}