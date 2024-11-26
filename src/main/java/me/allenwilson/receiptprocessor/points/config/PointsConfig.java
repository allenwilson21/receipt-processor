package me.allenwilson.receiptprocessor.points.config;

import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.points.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class PointsConfig {

    @Bean
    List<PointCalculationRule> pointCalculationRules() {
        return List.of(
                new RetailerNameRule(),
                new RoundDollarRule(),
                new TotalMultipleRule(),
                new ItemCountRule(),
                new ItemDescriptionRule(),
                new PurchaseDateRule(),
                new PurchaseTimeRule()
        );
    }

}
