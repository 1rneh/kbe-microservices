package com.henri.kbe.adapter.clients;

import com.henri.kbe.adapter.http.ApiException;
import com.henri.kbe.domain.dto.DeliveryInfoDto;
import com.henri.kbe.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class StorageServiceClient {

    public static final String DELIVERY_INFO_URL = "http://localhost:8083/rest/delivery-infos/{productName}";
    private final RestTemplate restTemplate;

    public DeliveryInfoDto getDeliveryInfoForProduct(@NotNull Product product) {

        if (product == null) throw new ApiException("Product must not be null. Calling storage service failed.");

        return restTemplate.getForObject(
                DELIVERY_INFO_URL,
                DeliveryInfoDto.class,
                product.getName()
        );
    }
}
