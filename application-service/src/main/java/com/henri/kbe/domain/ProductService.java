package com.henri.kbe.domain;

import com.henri.kbe.adapter.clients.CalculatorServiceClient;
import com.henri.kbe.adapter.clients.OpenWeatherApiClient;
import com.henri.kbe.adapter.clients.StorageServiceClient;
import com.henri.kbe.adapter.data.ProductRepository;
import com.henri.kbe.domain.model.Product;
import com.henri.kbe.domain.dto.DeliveryInfoDto;
import com.henri.kbe.domain.dto.ProductDetailsDto;
import com.henri.kbe.domain.dto.ProductDto;
import com.henri.kbe.domain.dto.TaxDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final CalculatorServiceClient calculatorServiceClient;
    private final StorageServiceClient storageServiceClient;
    private final OpenWeatherApiClient openWeatherApiClient;
    private final ProductRepository productRepository;

    public void addNewProduct(ProductDto productDto) {

        if (productRepository.existsByName(productDto.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product name already exists");
        }
        productRepository.save(
                new Product(
                        productDto.name(),
                        productDto.description(),
                        productDto.price(),
                        productDto.edible(),
                        productDto.origin()
                )
        );
    }

    public List<ProductDto> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product ->
                        new ProductDto(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.isEdible(),
                                product.getOrigin(),
                                product.getDeliveryDate()
                        ))
                .collect(Collectors.toList());
    }

    public ProductDetailsDto getProduct(long productId) {
        return productRepository
                .findById(productId)
                .map(product -> retrieveProductInformation(product))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Id doesn't exist"));
    }

    private ProductDetailsDto retrieveProductInformation(Product product) {

        DeliveryInfoDto deliveryInfoDto = storageServiceClient.getDeliveryInfoForProduct(product);
        TaxDto taxDto = calculatorServiceClient.getTaxCalculationForProduct(product);

        return new ProductDetailsDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                taxDto.tax(),
                product.isEdible(),
                product.getOrigin(),
                product.getDeliveryDate(),
                deliveryInfoDto.deliveryTime(),
                deliveryInfoDto.amount(),
                deliveryInfoDto.location());
    }

    public Object checkoutWeather(String country) {

        if (country == null) throw new ResponseStatusException(HttpStatus.CONFLICT, "Country/city must not be null");
        return openWeatherApiClient.checkoutWeather(country);
    }
}
