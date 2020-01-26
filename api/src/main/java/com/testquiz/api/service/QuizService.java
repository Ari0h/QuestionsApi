package com.testquiz.api.service;

import com.testquiz.api.DTOModel.QuizDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QuizService {

    Page<QuizDTO> getAllQuizes(String filter, Pageable pageable);

    void createQuiz(QuizDTO quiz);

    void editQuiz(QuizDTO quiz, Long id);

    void deleteQuiz(Long quizId);

    QuizDTO getQuiz(Long quizId);
}
