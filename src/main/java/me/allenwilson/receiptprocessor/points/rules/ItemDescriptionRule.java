package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.PurchaseItemDto;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemDescriptionRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return dto.items().stream()
                .filter(item -> item.shortDescription().trim().length() % 3 == 0)
                .map(PurchaseItemDto::price)
                .map(itemPrice -> itemPrice.multiply(BigDecimal.valueOf(0.2)).setScale(0, RoundingMode.UP))
                .mapToInt(BigDecimal::intValue)
                .sum();
    }
}
