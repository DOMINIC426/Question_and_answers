package com.example.auditing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long questionId;
    private String question;
    private String category;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

}
