package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

import java.math.BigDecimal;

public class TotalMultipleRule implements PointCalculationRule {
    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return dto.total().divide(BigDecimal.valueOf(.25))
                .remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0 ? 25 : 0;
    }
}
