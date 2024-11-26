package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

public class PurchaseDateRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return dto.purchaseDate().getDayOfMonth() % 2 != 0 ? 6 : 0;
    }
}
