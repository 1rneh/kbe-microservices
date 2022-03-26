package product;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/products")
public record ProductController(ProductService productService) {

    @PostMapping
    public void addProduct(@RequestBody ProductAddingRequest productAddingRequest) {
        log.info("product added: {}", productAddingRequest);
        productService.addNewProduct(productAddingRequest);
    }

}
