package com.testquiz.api.service;

import com.testquiz.api.dao.QuizDao;
import com.testquiz.api.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("quizService")
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDao quizDao;

    @Override
    public List<Quiz> getAllQuizes(Pageable pageable) {
    return quizDao.getAllQuizes(pageable);
    }

    @Override
    public void createQuiz(Quiz quiz) {
        quizDao.insertQuiz(quiz);
    }

    @Override
    public void editQuiz(Quiz newQuiz) {
        Quiz quiz = quizDao.getQuiz(newQuiz.getId());
        quiz.clone(newQuiz);
        quizDao.editQuiz(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizDao.deleteQuiz(quizId);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizDao.getQuiz(quizId);
    }


}
