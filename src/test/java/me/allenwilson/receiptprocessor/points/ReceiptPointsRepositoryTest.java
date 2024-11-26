package me.allenwilson.receiptprocessor.points;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReceiptPointsRepositoryTest {

    @Test
    @DisplayName("should save new point entity")
    void shouldSaveNewEntity() {
        var repository = new ReceiptPointsRepository();
        var entity = new PointEntity(UUID.randomUUID(), 100);

        PointEntity saved = repository.save(entity);

        assertThat(saved)
                .usingRecursiveComparison()
                .isEqualTo(entity);
    }

    @Test
    @DisplayName("should not update existing entity")
    void shouldNotUpdateExistingEntity() {
        var repository = new ReceiptPointsRepository();
        var id = UUID.randomUUID();
        var original = new PointEntity(id, 100);
        var updated = new PointEntity(id, 200);

        repository.save(original);
        PointEntity result = repository.save(updated);

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(original);
    }

}
