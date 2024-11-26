package me.allenwilson.receiptprocessor.points;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ReceiptPointsRepository {

    private final Map<UUID, PointEntity> pointEntityMap = new ConcurrentHashMap<>();

    public PointEntity save(PointEntity pointEntity) {
        pointEntityMap.putIfAbsent(pointEntity.id(), pointEntity);
        return pointEntityMap.get(pointEntity.id());
    }

    public PointEntity findById(UUID id) {
        return pointEntityMap.get(id);
    }
}
