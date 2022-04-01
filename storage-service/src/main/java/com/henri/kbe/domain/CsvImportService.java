package com.henri.kbe.domain;

import com.henri.kbe.adapter.data.ProductRepository;
import com.henri.kbe.domain.model.ProductDetails;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.file.Files;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class CsvImportService {

    private final ProductRepository productRepository;
    public static final String FILENAME = "./total_product_details.csv";

    public List<ProductDetails> getProductDetails() {
        List<ProductDetails> storedProductDetails = productRepository.findAll();
        if (storedProductDetails.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No details stored");
        return storedProductDetails;
    }
    public void importData() {
        try {
            List<ProductDetails> storedProductDetails = productRepository.findAll();
            if (!storedProductDetails.isEmpty()) emptyTable();
            productRepository.saveAll(readCSV());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Import failed");
        }
    }

    public List<ProductDetails> readCSV() throws IOException {
        try (CSVParser csvParser = new CSVParser(Files.newBufferedReader(new File(FILENAME).toPath()),
                CSVFormat.DEFAULT.withHeader());) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            return StreamSupport.stream(csvRecords.spliterator(), false)
                    .map(this::toProductDetails).collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException("Csv import failed", e);
        }
    }

    private ProductDetails toProductDetails(CSVRecord record) {
        String name = record.get("name");
        String description = record.get("description");
        double price = Double.parseDouble(record.get("price"));
        double tax = Double.parseDouble(record.get("tax"));
        boolean edible = Boolean.parseBoolean(record.get("edible"));
        String origin = record.get("origin");
        LocalDate deliveryDate = LocalDate.parse(record.get("deliveryDate"));
        long deliveryTime = Time.valueOf(record.get("deliveryTime")).getTime();
        int amount = Integer.parseInt(record.get("amount"));
        String location = record.get("location");

        return new ProductDetails(
                name, description, price, tax, edible, origin, deliveryDate, deliveryTime, amount, location);
    }

    public void emptyTable() {
        productRepository.deleteAll();
    }
}
