package com.henri.kbe.calculator;
import com.henri.kbe.calculator.domain.CalculatorService;
import com.henri.kbe.calculator.domain.TaxCalculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

    @Test
    void whenPriceIsNegative_thenResponseStatusExceptionIsThrown() {
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

    @Test
    void whenPriceIsNegative_thenIllegalArgumentExceptionIsThrown() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double negativePrice = -1;

        assertThrows(IllegalArgumentException.class,
                () -> taxCalculator.calculateTax(negativePrice) );
    }

    @Test
    void whenPriceIsCorrect_thenCalculateCorrectTax() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double price = 2.99;

        double actual = taxCalculator.calculateTax(price);

        double expected = 0.5681;
        assertEquals(expected, actual);
    }

}