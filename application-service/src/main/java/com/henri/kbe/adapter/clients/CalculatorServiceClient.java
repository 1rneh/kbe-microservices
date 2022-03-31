package com.henri.kbe.adapter.clients;

import com.henri.kbe.adapter.http.ApiException;
import com.henri.kbe.domain.dto.TaxDto;
import com.henri.kbe.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class CalculatorServiceClient {

    public static final String TAX_CALCULATION_URL = "http://localhost:8082/rest/calculator/{productPrice}";
    private final RestTemplate restTemplate;

    public TaxDto getTaxCalculationForProduct(@NotNull Product product) {

        if (product == null) throw new ApiException("Product must not be null. Calling calculator service failed.");

        return restTemplate.getForObject(
                TAX_CALCULATION_URL,
                TaxDto.class,
                product.getPrice()
        );
    }
}
