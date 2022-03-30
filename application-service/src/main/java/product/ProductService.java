package product;

import calculatorResponse.CalculatorResponse;
import deliveryinfoResponse.DeliveryInfo;
import deliveryinfoResponse.DeliveryInfoResponse;
import dtoResponse.ProductDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public void addNewProduct(ProductAddingRequest request) {

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .edible(request.edible())
                .build();

        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductDto getProduct(long productId) throws IllegalStateException {

        return productRepository
                .findById(productId)
                .map(product -> retrieveProductInformation(product))
                .orElseThrow(() -> new IllegalStateException("product doen't exist."));
    }

    private ProductDto retrieveProductInformation(Product product) {
        DeliveryInfoResponse deliveryInfoResponse = restTemplate.getForObject(
                "https://storage-service/rest/delivery-infos/{productName}",
                DeliveryInfoResponse.class,
                product.getName()
        );
        CalculatorResponse calculatorResponse = restTemplate.getForObject(
                "https://calculator-service/rest/calculator/{productPrice}",
                CalculatorResponse.class,
                product.getPrice()
        );

        return new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                calculatorResponse.tax(),
                product.isEdible(),
                product.getOrigin(),
                product.getDeliveryDate(),
                deliveryInfoResponse.deliveryInfo().getDeliveryTime(),
                deliveryInfoResponse.deliveryInfo().getAmount(),
                deliveryInfoResponse.deliveryInfo().getLocation());
    }
}
