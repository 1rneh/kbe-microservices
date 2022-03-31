package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Time;

public record DeliveryInfosDto(
        @NotNull
        Time deliveryTime,
        String location,
        @NotNull
        BigDecimal amount
) { }

