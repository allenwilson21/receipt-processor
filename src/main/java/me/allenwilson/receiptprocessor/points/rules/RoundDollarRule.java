package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

import java.math.BigDecimal;

public class RoundDollarRule implements PointCalculationRule {

    @Override
    public int calculatePoints(ReceiptRequestDto dto) {
        return dto.total().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0 ? 50 : 0;
    }
}