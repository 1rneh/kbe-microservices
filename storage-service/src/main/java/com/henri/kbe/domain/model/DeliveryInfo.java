package com.henri.kbe.domain.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Time;

@Data
@Document
public class DeliveryInfo {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private long deliveryTime;

    private BigDecimal amount;

    private String location;

    public DeliveryInfo(String name, long deliveryTime, BigDecimal amount, String location) {
        this.name = name;
        this.deliveryTime = deliveryTime;
        this.amount = amount;
        this.location = location;
    }
}
