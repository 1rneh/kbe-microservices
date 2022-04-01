package com.henri.kbe.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document
public class ProductDetails {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String description;

    private double price;

    private double tax;

    private boolean edible;

    private String origin;

    private LocalDate deliveryDate;

    private long deliveryTime;

    private int amount;

    private String location;

    public ProductDetails(String name, String description, double price, double tax, boolean edible, String origin, LocalDate deliveryDate, long deliveryTime, int amount, String location) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.edible = edible;
        this.origin = origin;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.amount = amount;
        this.location = location;
    }
}
