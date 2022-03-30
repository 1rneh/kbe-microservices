package com.henri.kbe.calculator.adapter.http;

import com.henri.kbe.calculator.domain.CalculatorService;
import com.henri.kbe.calculator.domain.dto.TaxDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

@Builder
@AllArgsConstructor
@RestController
@RequestMapping("rest/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping(path = "{price}")
    public TaxDto calculateTax(
            @PathVariable("price") double price
    ) {
        return calculatorService.calculateMehrwertsteuer(price);
    }
}
