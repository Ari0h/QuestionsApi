package com.testquiz.api.service;

import com.testquiz.api.dao.QuizDao;
import com.testquiz.api.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void createQuiz(Quiz quiz) {
        quizDao.insertQuiz(quiz);
    }

    @Override
    @Transactional
    public void editQuiz(Quiz newQuiz) {
        Quiz quiz = quizDao.getQuiz(newQuiz.getId());
        quiz.clone(newQuiz);
        quizDao.editQuiz(quiz);
    }

    @Override
    @Transactional
    public void deleteQuiz(Long quizId) {
        quizDao.deleteQuiz(quizId);
    }

    @Override
    @Transactional
    public Quiz getQuiz(Long quizId) {
        return quizDao.getQuiz(quizId);
    }


}
