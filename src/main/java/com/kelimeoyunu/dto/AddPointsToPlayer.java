package com.kelimeoyunu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPointsToPlayer {

    private Integer points;
    private Integer playerId;
}
