package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import java.sql.Time;

public record DeliveryInfoDto(
        @NotNull
        String id,
        @NotNull
        String name,
        @NotNull
        Time deliveryTime,
        String location,
        @NotNull
        int amount
) { }
