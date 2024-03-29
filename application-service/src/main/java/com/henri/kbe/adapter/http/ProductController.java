package com.henri.kbe.adapter.http;

import com.henri.kbe.domain.ProductService;
import com.henri.kbe.domain.dto.ProductDetailsDto;
import com.henri.kbe.domain.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("rest/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProduct(
            @Valid @RequestBody ProductDto productDto
    ) {
        productService.addNewProduct(productDto);
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("{productId}")
    public ProductDetailsDto getProduct(
            @PathVariable long productId
    ) {
        return productService.getProduct(productId);
    }

    @GetMapping({"/coordinates-for-origin/{origin}"})
    public Object getWeather(
            @PathVariable(value="origin") String origin
    ) {
        return productService.getCoordinates(origin);
    }

    @RequestMapping("/export")
    public void exportData() {
        productService.exportProducts();
    }

}
