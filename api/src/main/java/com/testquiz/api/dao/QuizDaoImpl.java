package com.testquiz.api.dao;

import com.testquiz.api.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("quizDao")
@Repository
public class QuizDaoImpl implements QuizDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public void editQuiz(Quiz quiz) {
    entityManager.merge(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = entityManager.find(Quiz.class, quizId);
        entityManager.remove(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return entityManager.find(Quiz.class, quizId);
    }

    @Override
    public Page<Quiz> getAllQuizes(String filter, Pageable pageable) {
            return quizRepo.findAll(pageable);
    }
}
