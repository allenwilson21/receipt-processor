package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

public class ItemCountRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return (dto.items().size() / 2) * 5;
    }
}
