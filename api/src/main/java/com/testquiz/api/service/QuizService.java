package com.testquiz.api.service;

import com.testquiz.api.DTOModel.QuizDTO;
import com.testquiz.api.DTOModel.WebFilter;
import org.springframework.data.domain.Page;


public interface QuizService {

    Page<QuizDTO> getAllQuizes(WebFilter webFilter);

    void createQuiz(QuizDTO quiz);

    void editQuiz(QuizDTO quiz, Long id);

    void deleteQuiz(Long quizId);

    QuizDTO getQuiz(Long quizId);
}
