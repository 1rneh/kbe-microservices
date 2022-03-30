package com.henri.kbe.domain.dto;

import lombok.Builder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Builder
public record ProductDetailsDto(
        @NotNull
        String name,
        String description,
        @NotNull
        @Positive
        double price,
        @NotNull
        @Positive
        double tax,
        boolean edible,
        String origin,
        @NotNull
        Date deliveryDate,
        @NotNull
        Date deliveryTime,
        int amount,
        String location
) { }
