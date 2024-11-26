package me.allenwilson.receiptprocessor.points;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PointEntity(
        UUID id,
        Integer points
) {}
