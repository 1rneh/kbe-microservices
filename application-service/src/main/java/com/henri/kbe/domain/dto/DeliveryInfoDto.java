package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public record DeliveryInfoDto(
        @NotNull
        Date deliveryTime,
        String location,
        @NotNull
        int amount
) { }
