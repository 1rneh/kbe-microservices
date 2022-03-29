package calculator;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculator {

    public Double calculateMehrwertsteuer(Double totalPrice) {

        return totalPrice * 0.19;
    }
}