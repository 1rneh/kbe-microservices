package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public record ProductDto(
        @NotNull
        String name,
        String description,
        @NotNull
        @Positive
        double price,
        boolean edible,
        @NotNull
        String origin,
        @NotNull
        Date deliveryDate
) {
}
