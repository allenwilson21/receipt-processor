package me.allenwilson.receiptprocessor.processor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PurchaseItemDto(
        @NotBlank(message = "Description required")
        String shortDescription,
        @NotNull(message = "Price required")
        @DecimalMin(value = ".01")
        @Digits(integer = 10, fraction = 2)
        BigDecimal price
) {
}
