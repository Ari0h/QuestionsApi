package com.testquiz.api.dao;

import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("quizDao")
@Repository
public class QuizDaoImpl implements QuizDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertQuiz(Quiz quiz) {
        entityManager.persist(quiz);
    }

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
    public List<Quiz> getAllQuizes(Pageable pageable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Quiz> cq = builder.createQuery(Quiz.class);
        Root<Quiz> root = cq.from(Quiz.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
}
