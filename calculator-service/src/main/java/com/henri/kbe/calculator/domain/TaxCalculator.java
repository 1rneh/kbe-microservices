package com.henri.kbe.calculator.domain;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculator {

    private static final double TAXRATE = 0.19;

    public double calculateMehrwertsteuer(double totalPrice) {

        return totalPrice * TAXRATE;
    }
}
