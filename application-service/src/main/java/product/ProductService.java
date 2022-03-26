package product;

import org.springframework.stereotype.Service;

@Service
public record ProductService() {

    public void addNewProduct(ProductAddingRequest request) {

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .isFood(request.isFood())
                .build();
        // todo: check if name is valid
        // todo: check if name not taken
        // todo: check product in db
    }
}
