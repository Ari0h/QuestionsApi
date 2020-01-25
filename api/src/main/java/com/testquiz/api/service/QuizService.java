package com.testquiz.api.service;

import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {

    List<Quiz> getAllQuizes(Pageable pageable);

    void createQuiz(Quiz quiz);

    void editQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Quiz getQuiz(Long quizId);
}
