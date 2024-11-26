package me.allenwilson.receiptprocessor.processor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.allenwilson.receiptprocessor.points.ReceiptPointsDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping("/process")
    ReceiptResponseDto processReceipt(@Valid @RequestBody ReceiptRequestDto receiptRequestDto) {
        return receiptService.process(receiptRequestDto);
    }

    @GetMapping("/{id}/points")
    ReceiptPointsDto getReceiptPoints(@PathVariable("id") UUID id) {
        return receiptService.getReceiptPoints(id);
    }
}
