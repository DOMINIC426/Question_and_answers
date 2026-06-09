package com.example.auditing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;
    @Column(nullable = false,name = "difficulty")
    private String difficulty="EASY";
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String category;
    @Column(name = "option_a", nullable = false)
    private String optionA;
    @Column(name = "option_b", nullable = false)
    private String optionB;
    @Column(name = "option_c", nullable = false)
    private String optionC;
    @Column(name = "option_d", nullable = false)
    private String optionD;
    @Column(nullable = false)
    private String answer;
}
