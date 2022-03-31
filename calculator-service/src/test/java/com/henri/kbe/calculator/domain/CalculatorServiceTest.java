package com.henri.kbe.calculator.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

    @Test
    void whenPriceIsNegative_thenExceptionIsThrown() {
        CalculatorService calculatorService = new CalculatorService(new TaxCalculator());
        double negativePrice = -1;

        assertThrows(ResponseStatusException.class,
                () -> calculatorService.calculateMehrwertsteuer(negativePrice));
    }

    @Test
    void whenPriceIsCorrect_thenMethodByTaxCalculatorIsInvoced() {
        TaxCalculator taxCalculatorMock = Mockito.mock(TaxCalculator.class);
        CalculatorService calculatorService = new CalculatorService(taxCalculatorMock);
        when(taxCalculatorMock.calculateTax(anyDouble())).thenReturn(anyDouble());
        double correctPrice = 2.99;

        calculatorService.calculateMehrwertsteuer(correctPrice);

        verify(taxCalculatorMock,times(1)).calculateTax(correctPrice);
    }

}