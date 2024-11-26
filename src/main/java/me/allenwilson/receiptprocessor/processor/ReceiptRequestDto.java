package me.allenwilson.receiptprocessor.processor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record ReceiptRequestDto(
        @NotBlank(message = "Retailer required")
        String retailer,
        @NotNull(message = "Purchase date required")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate purchaseDate,
        @NotNull(message = "Purchase time required")
        @JsonFormat(pattern = "HH:mm")
        LocalTime purchaseTime,
        @Valid
        @Size(min = 1, message = "The receipt must have at least one item.")
        List<PurchaseItemDto> items,
        @NotNull(message = "Total required")
        @DecimalMin(value = ".01")
        @Digits(integer = 10, fraction = 2)
        BigDecimal total
) {
}
