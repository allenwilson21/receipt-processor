package me.allenwilson.receiptprocessor.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.allenwilson.receiptprocessor.points.PointCalculationRule;
import me.allenwilson.receiptprocessor.points.PointEntity;
import me.allenwilson.receiptprocessor.points.ReceiptPointsDto;
import me.allenwilson.receiptprocessor.points.ReceiptPointsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
class ReceiptService {

    private final List<PointCalculationRule> pointCalculationRules;
    private final ReceiptPointsRepository pointsRepository;

    ReceiptResponseDto process(ReceiptRequestDto receiptRequestDto) {
        int receiptPoints = calculatePoints(receiptRequestDto);

        PointEntity savedEntity = pointsRepository.save(PointEntity.builder()
                .id(UUID.randomUUID())
                .points(receiptPoints)
                .build());

        log.info("Receipt id {} processed with {} points", savedEntity.id(), savedEntity.points());
        return new ReceiptResponseDto(savedEntity.id());    }

    ReceiptPointsDto getReceiptPoints(UUID id) {
        PointEntity pointEntity = pointsRepository.findById(id);

        if (pointEntity == null) {
            throw new ReceiptProcessingException("Receipt not found");
        }

        log.info("Returning points for receipt with id: {}", id);
        return new ReceiptPointsDto(pointEntity.points());
    }

    private int calculatePoints(ReceiptRequestDto dto) {
        int total = pointCalculationRules.stream()
                .mapToInt(rule -> {
                    int points = rule.calculatePoints(dto);

                    // Logging this for the sake of the example
                    log.info("Rule {} calculated {} points", rule.getClass().getSimpleName(), points);

                    return points;
                })
                .sum();

        // Logging this for the sake of the example
        log.info("Total points calculated: {}", total);
        return total;
    }
}
