package me.allenwilson.receiptprocessor.processor;

import me.allenwilson.receiptprocessor.points.PointEntity;
import me.allenwilson.receiptprocessor.points.ReceiptPointsDto;
import me.allenwilson.receiptprocessor.points.ReceiptPointsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReceiptServiceTest {
    @Mock
    private ReceiptPointsRepository pointsRepository;

    @InjectMocks
    private ReceiptService receiptService;

    @Nested
    @DisplayName("getReceiptPoints")
    class GetReceiptPoints {
        @Test
        @DisplayName("should return points for existing receipt")
        void shouldReturnPointsForExistingReceipt() {
            UUID id = UUID.randomUUID();
            var entity = new PointEntity(id, 100);
            when(pointsRepository.findById(id)).thenReturn(entity);

            ReceiptPointsDto response = receiptService.getReceiptPoints(id);

            assertThat(response.points()).isEqualTo(100);
        }

        @Test
        @DisplayName("should throw exception when receipt not found")
        void shouldThrowExceptionWhenNotFound() {
            UUID id = UUID.randomUUID();
            when(pointsRepository.findById(id)).thenReturn(null);

            assertThatThrownBy(() -> receiptService.getReceiptPoints(id))
                    .isInstanceOf(ReceiptProcessingException.class)
                    .hasMessageContaining("Receipt not found");
        }
    }
}
