package product;

import org.springframework.stereotype.Service;

@Service
public record ProductService(ProductRepository productRepository) {

    public void addNewProduct(ProductAddingRequest request) {

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .isFood(request.isFood())
                .build();
        // todo: check if name is valid
        // todo: check if name not taken

        productRepository.save(product);
    }

}
