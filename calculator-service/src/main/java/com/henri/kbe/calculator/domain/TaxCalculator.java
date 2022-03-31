package com.henri.kbe.calculator.domain;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Service
public class TaxCalculator {

    private static final double TAXRATE = 0.19;

    public double calculateTax(@Positive @NotNull double price) {

        if (price < 0 ) throw new IllegalArgumentException("Price must not be negative");

        return price * TAXRATE;
    }
}
