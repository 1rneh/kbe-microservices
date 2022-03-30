package com.henri.kbe.calculator.domain;

import com.henri.kbe.calculator.domain.dto.TaxDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CalculatorService {

    private final TaxCalculator taxCalculator;

    public TaxDto calculateMehrwertsteuer(double price) {

        if (price < 0)  {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Price must be a positive number.");
        }
        return new TaxDto(taxCalculator.calculateMehrwertsteuer(price));
    }
}
