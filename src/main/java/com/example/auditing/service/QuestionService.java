package com.example.auditing.service;

import com.example.auditing.dto.QuestionRequest;
import com.example.auditing.dto.QuestionResponse;
import com.example.auditing.entity.Auditing;
import com.example.auditing.entity.Question;
import com.example.auditing.repository.AuditingRepository;
import com.example.auditing.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final AuditingRepository auditingRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public List<QuestionResponse> addQuestions(List<QuestionRequest> questionRequests) {

        List<Question> questionsToSave = questionRequests.stream()
                .map(request -> modelMapper.map(request, Question.class))
                .toList();

        // 2. Save to database
        List<Question> savedQuestions = questionRepository.saveAll(questionsToSave);
        Auditing auditing = new Auditing();
        auditing.setCreated(LocalDateTime.now());
        auditing.setUserName("admin");
        auditing.setActivity("Adding Question ");
        auditingRepository.save(auditing);

        // 3. Map List<Question> back to List<QuestionResponse>
        return savedQuestions.stream()
                .map(saved -> modelMapper.map(saved, QuestionResponse.class))
                .toList();
    }



    public List<QuestionResponse> getByCategory(String category) {
        List<Question> questionList=questionRepository.findByCategory(category);

        Auditing auditing = new Auditing();
        auditing.setActivity("Find the Question of Category " + category);
        auditing.setUserName("admin");
        auditing.setCreated(LocalDateTime.now());
        auditingRepository.save(auditing);


        return questionList.stream()
                .map(request->modelMapper.map(request, QuestionResponse.class))
                .toList();
    }
}
