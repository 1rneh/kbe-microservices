package com.henri.kbe.adapter.clients;

import com.henri.kbe.domain.dto.ProductDetailsDto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CsvExportingClient {

    private final String FILENAME = "total_product_details.csv";
    private final String[] HEADER = {"name", "description", "price", "tax", "edible", "origin", "deliveryDate", "deliveryTime", "amount", "location"};

    public void exportCsv(List<ProductDetailsDto> productDtos) {


        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(FILENAME), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(HEADER);
            for (ProductDetailsDto product : productDtos) {
                csvPrinter.printRecord(
                        product.name(),
                        product.description(),
                        product.price(),
                        product.tax(),
                        product.edible(),
                        product.origin(),
                        product.deliveryDate(),
                        product.deliveryTime(),
                        product.amount(),
                        product.location());
            }
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Import failed.");
        }

    }
}
