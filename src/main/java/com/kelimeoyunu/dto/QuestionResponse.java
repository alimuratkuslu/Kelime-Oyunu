package com.kelimeoyunu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponse {

    private String description;

    private String answer;

    private Integer point;
}
