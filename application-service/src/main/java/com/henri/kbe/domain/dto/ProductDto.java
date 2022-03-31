package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public record ProductDto(
        @NotNull
        long id,
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
        LocalDate deliveryDate
) {
}
