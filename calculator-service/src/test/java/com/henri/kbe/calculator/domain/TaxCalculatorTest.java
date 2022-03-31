package com.henri.kbe.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxCalculatorTest {

    @Test
    void whenPriceIsNegative_thenExceptionIsThrown() {
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