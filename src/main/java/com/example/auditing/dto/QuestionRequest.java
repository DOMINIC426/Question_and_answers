package com.example.auditing.dto;

import lombok.Data;

@Data
public class QuestionRequest {
    private String question;
    private String category;
    private String difficulty;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
}
