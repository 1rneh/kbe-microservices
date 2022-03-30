package com.henri.kbe.adapter.clients;

import com.henri.kbe.domain.dto.TaxDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
public class ExternalApiClient {

    public static final String EXTERNAL_API = "https://calculator-service/rest/calculator/{productPrice}";

    @Qualifier("qualifiedBean")
    private final RestTemplate restTemplate;

    public TaxDto callExternalAPI() {

        return null;
        /*
                restTemplate.getForObject(
                EXTERNAL_API,
                TaxDto.class,
                product.getPrice()
        );

         */
    }
}
