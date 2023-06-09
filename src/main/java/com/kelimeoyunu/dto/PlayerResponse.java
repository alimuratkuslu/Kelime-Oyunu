package com.kelimeoyunu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {

    private Integer id;
    private String name;
    private Integer points;
}
