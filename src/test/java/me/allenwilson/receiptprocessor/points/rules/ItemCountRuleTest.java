package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.processor.PurchaseItemDto;
import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ItemCountRuleTest {
    private final ItemCountRule rule = new ItemCountRule();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("should award 5 points for every two items")
    void calculatePoints(int itemCount) {
        List<PurchaseItemDto> items = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            items.add(new PurchaseItemDto("Item " + i, BigDecimal.ONE));
        }

        ReceiptRequestDto receipt = new ReceiptRequestDto(
                "Target",
                LocalDate.parse("2024-01-01"),
                LocalTime.parse("14:00"),
                items,
                BigDecimal.TEN
        );

        int expectedPoints = (itemCount / 2) * 5;
        assertThat(rule.calculatePoints(receipt)).isEqualTo(expectedPoints);
    }
}
