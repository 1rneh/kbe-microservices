package dtoResponse;

import lombok.Builder;

import java.util.Date;

@Builder
public record ProductDto(
        String name,
        String description,
        double price,
        double tax,
        boolean edible,
        String origin,
        Date deliveryDate,
        Date deliveryTime,
        int amount,
        String location
) { }
