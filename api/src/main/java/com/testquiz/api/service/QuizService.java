package com.testquiz.api.service;

import com.testquiz.api.DTOModel.QuizDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {

    List<QuizDTO> getAllQuizes(Pageable pageable);

    void createQuiz(QuizDTO quiz);

    void editQuiz(QuizDTO quiz, Long id);

    void deleteQuiz(Long quizId);

    QuizDTO getQuiz(Long quizId);
}
