package com.testquiz.api.dao;

import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QuizDao {

    void editQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Quiz getQuiz(Long quizId);

    Page<Quiz> getAllQuizes(String filter, Pageable pageable);

}
