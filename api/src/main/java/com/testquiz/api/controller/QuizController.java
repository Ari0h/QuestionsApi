package com.testquiz.api.controller;

import com.testquiz.api.model.Quiz;
import com.testquiz.api.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    public List<Quiz> getAllQuizes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return quizService.getAllQuizes(pageable);
    }
}
