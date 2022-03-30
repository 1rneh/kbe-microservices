package com.henri.kbe.calculator.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record TaxDto(
        @NotNull
        @Positive
        double tax
) { }