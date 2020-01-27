package com.testquiz.api.dao;

import com.testquiz.api.DTOModel.WebFilter;
import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Page;


public interface QuizDao {

    void editQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Quiz getQuiz(Long quizId);

    Page<Quiz> getAllQuizes(WebFilter webFilter);

}
