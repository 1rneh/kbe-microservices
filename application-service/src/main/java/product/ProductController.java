package product;


import dtoResponse.ProductDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("rest/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductAddingRequest productAddingRequest) {
        productService.addNewProduct(productAddingRequest);
        log.info("added product: {}", productAddingRequest);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(
            @PathVariable long productId
    ) {
        return productService.getProduct(productId);
    }

}
