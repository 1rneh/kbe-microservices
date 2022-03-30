package calculator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatorService {

    private final TaxCalculator taxCalculator;

    public double calculateMehrwertsteuer(double price) {
        return taxCalculator.calculateMehrwertsteuer(price);
    }
}
