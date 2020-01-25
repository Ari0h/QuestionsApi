package com.testquiz.api.dao;

import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizDao {

    void insertQuiz(Quiz quiz);

    void editQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Quiz getQuiz(Long quizId);

    List<Quiz> getAllQuizes(Pageable pageable);

}
