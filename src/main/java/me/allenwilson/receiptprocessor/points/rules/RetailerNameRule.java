package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

public class RetailerNameRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return (int) dto.retailer().trim().chars()
                .filter(Character::isLetterOrDigit)
                .count();
    }
}
