package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

import java.time.LocalTime;

public class PurchaseTimeRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return dto.purchaseTime().isAfter(LocalTime.of(13, 59, 59))
                && dto.purchaseTime().isBefore(LocalTime.of(16, 0, 0))
                ? 10 : 0;

    }
}
