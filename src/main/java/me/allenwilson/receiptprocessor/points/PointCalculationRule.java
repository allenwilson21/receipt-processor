package me.allenwilson.receiptprocessor.points;

import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;

/**
 * This interface defines the contract for a rule that calculates points for a receipt.
 * To implement a new rule, create a new class that implements this interface and add
 * it to the list of rules in the
 * {@link me.allenwilson.receiptprocessor.points.config.PointsConfig} class.
* */
public interface PointCalculationRule {
    int calculatePoints(ReceiptRequestDto dto);
}
