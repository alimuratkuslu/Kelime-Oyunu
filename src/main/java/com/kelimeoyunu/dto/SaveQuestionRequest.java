package com.kelimeoyunu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveQuestionRequest {

    private String description;

    private String answer;
}
