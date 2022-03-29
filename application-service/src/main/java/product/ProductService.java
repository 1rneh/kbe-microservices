package product;

import deliveryinfoResponse.DeliveryInfoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Product getProduct(Integer productId) throws IllegalStateException {
        Optional<Product> productOption = productRepository.findById(productId);

        productOption.ifPresent(
                product -> {
                    DeliveryInfoResponse deliveryInfoResponse = restTemplate.getForObject(
                            "http://localhost:8081/api/v1/delivery-infos/{productId}",
                            DeliveryInfoResponse.class,
                            product.getId()
                    );
                    log.info("received deliveryInfo: " + deliveryInfoResponse.deliveryInfo());
                }
        );

        return productOption
                .orElseThrow(() -> new IllegalStateException("product doen't exist."));
    }
}
