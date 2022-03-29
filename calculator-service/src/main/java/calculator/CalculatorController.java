package calculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Builder
@AllArgsConstructor
@RestController
@RequestMapping("rest/calculator")
public class CalculatorController {

    private final TaxCalculator taxCalculator;

    @GetMapping(path = "{price}")
    public Double getTax(
            @PathVariable("price") Double price
    ) {
        return taxCalculator.calculateMehrwertsteuer(price);
    }
}