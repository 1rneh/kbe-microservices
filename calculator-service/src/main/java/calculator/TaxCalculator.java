package calculator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TaxCalculator {

    private static final double TAXRATE = 0.19;

    public double calculateMehrwertsteuer(double totalPrice) {

        return totalPrice * TAXRATE;
    }
}
