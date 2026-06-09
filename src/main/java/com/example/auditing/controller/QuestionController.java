package com.example.auditing.controller;

import com.example.auditing.dto.QuestionRequest;
import com.example.auditing.dto.QuestionResponse;
import com.example.auditing.service.QuestionService;
import jakarta.servlet.ServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class QuestionController {
    private final QuestionService questionService;


    @PostMapping("/add-question")
    public ResponseEntity<List<QuestionResponse>> addQuestion(@RequestBody List<QuestionRequest> questionRequest) {
        return ResponseEntity.ok(questionService.addQuestions(questionRequest));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionResponse>> findByCategory(@PathVariable String category) {
        return ResponseEntity.ok(questionService.getByCategory(category));
    }
}
