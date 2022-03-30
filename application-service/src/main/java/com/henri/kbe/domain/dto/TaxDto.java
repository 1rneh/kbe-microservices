package com.henri.kbe.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record TaxDto(
        @NotNull
        @Positive
        double tax
) { }