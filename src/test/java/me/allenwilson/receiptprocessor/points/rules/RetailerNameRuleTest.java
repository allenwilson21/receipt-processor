package me.allenwilson.receiptprocessor.points.rules;

import me.allenwilson.receiptprocessor.processor.ReceiptRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RetailerNameRuleTest {
    private final RetailerNameRule rule = new RetailerNameRule();

    @ParameterizedTest
    @CsvSource({
            "Target,6",
            "Target Store,11",
            "M&M Corner Market,14",
            "'',0",
            "'   ',0",
    })
    @DisplayName("should calculate points based on alphanumeric characters in retailer name")
    void calculatePoints(String retailerName, int expectedPoints) {
        ReceiptRequestDto receipt = new ReceiptRequestDto(
                retailerName,
                LocalDate.parse("2024-01-01"),
                LocalTime.parse("14:00"),
                List.of(),
                BigDecimal.TEN
        );

        assertThat(rule.calculatePoints(receipt)).isEqualTo(expectedPoints);
    }
}
