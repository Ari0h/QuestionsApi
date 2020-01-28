package com.testquiz.api.utils;

import com.testquiz.api.DTOModel.QuestionDTO;
import com.testquiz.api.DTOModel.QuizDTO;
import com.testquiz.api.DTOModel.WebFilter;
import com.testquiz.api.model.Question;
import com.testquiz.api.model.Quiz;

import java.util.*;

public class ModelConverter {

    public static void converterDTOtoDBOQuiz(QuizDTO quizDTO, Quiz quiz){
        quiz.setId(quizDTO.getId());
        quiz.setQuizName(quizDTO.getQuizName());
        quiz.setStartDate(quizDTO.getStartDate());
        quiz.setEndDate(quizDTO.getEndDate());
        quiz.setActive(quizDTO.getActive());
        if (quiz.getQuestions() != null){
            quiz.getQuestions().clear();
        } else {
            quiz.setQuestions(new HashSet<>());
        }
        for (QuestionDTO questionDTO : quizDTO.getQuestions()){
            Question question = new Question(questionDTO);
            question.setQuiz(quiz);
            quiz.getQuestions().add(question);
        }
    }

    public static void converterDBOtoDTOQuiz(QuizDTO quizDTO, Quiz quiz){
        converterDBOtoDTOQuiz(quizDTO, quiz, null);
    }

    public static void converterDBOtoDTOQuiz(QuizDTO quizDTO, Quiz quiz, WebFilter webFilter){
        quizDTO.setId(quiz.getId());
        quizDTO.setQuizName(quiz.getQuizName());
        quizDTO.setStartDate(quiz.getStartDate());
        quizDTO.setEndDate(quiz.getEndDate());
        quizDTO.setActive(quiz.getActive());
        TreeSet<QuestionDTO> questionsDTO = new TreeSet<>(Comparator.comparing(QuestionDTO::getFilterNumber));
        for (Question question : quiz.getQuestions()){
            QuestionDTO questionDTO = new QuestionDTO();
            converterDBOtoDTOQuestions(questionDTO, question);
            questionsDTO.add(questionDTO);
        }
        if (webFilter!= null && webFilter.getSort().contains("-filterNumber")){
            quizDTO.setQuestions( questionsDTO.descendingSet());
        } else {
            quizDTO.setQuestions( questionsDTO);
        }
    }

    private static void converterDBOtoDTOQuestions(QuestionDTO questionDTO, Question question){
        questionDTO.setId(question.getId());
        questionDTO.setQuizId(question.getQuiz().getId());
        questionDTO.setQuestionText(question.getQuestionText());
        questionDTO.setFilterNumber(question.getFilterNumber());
    }
}
