package com.henri.kbe.adapter.http;

import com.henri.kbe.adapter.CsvImportService;
import com.henri.kbe.domain.model.ProductDetails;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rest/storage-products")
public class CsvImportController {

    private final CsvImportService csvImportService;

    @GetMapping
    public List<ProductDetails> getProductDetails() {
        return csvImportService.getProductDetails();
    }

    @PostMapping("/import")
    public void importProductDetails() {
        csvImportService.importData();
    }

    @DeleteMapping
    public void deleteProducts() {
        csvImportService.emptyTable();
    }

}

