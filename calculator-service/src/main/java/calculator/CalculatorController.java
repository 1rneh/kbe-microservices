package calculator;

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
    public CalculatorResponse calculateTax(
            @PathVariable("price") double price
    ) {
        double tax = calculatorService.calculateMehrwertsteuer(price);
        return new CalculatorResponse(tax);
    }
}
