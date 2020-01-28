package com.testquiz.api.dao;

import com.testquiz.api.DTOModel.Filter;
import com.testquiz.api.DTOModel.WebFilter;
import com.testquiz.api.model.Question;
import com.testquiz.api.model.Quiz;
import com.testquiz.api.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public Page<Quiz> getAllQuizes(WebFilter webFilter) {
        List<Filter> filterList = FilterUtils.parseFilter(webFilter.getSort());
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Quiz> cq = builder.createQuery(Quiz.class);
        Root<Quiz> root = cq.from(Quiz.class);
        Join<Quiz, Question> question = root.join("questions");
        ArrayList<Predicate> predicates = prepareCriteria(webFilter, builder, root, question);
        cq.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        addOrderByToCriteria(cq, builder, root, question, filterList);
        TypedQuery<Quiz> query = entityManager.createQuery(cq);
        query.setFirstResult(webFilter.getFirstResult());
        query.setMaxResults(webFilter.getSize());
        List<Quiz> resultList = query.getResultList();
        return new PageImpl<>(resultList);
    }

    private void addOrderByToCriteria(CriteriaQuery<Quiz> cq, CriteriaBuilder builder, Root<Quiz> root, Join<Quiz, Question> question, List<Filter> filterList) {
        for (Filter filter : filterList) {
            if (!filter.getFilterName().equals("filterNumber")) {
                switch (filter.getOrderBy()) {
                    case "asc":
                        cq.orderBy(builder.asc(root.get(filter.getFilterName())));
                        break;
                    case "desc":
                        cq.orderBy(builder.desc(root.get(filter.getFilterName())));
                }
            }
        }
    }

    private ArrayList<Predicate> prepareCriteria(WebFilter filter, CriteriaBuilder builder, Root<Quiz> root, Join<Quiz, Question> question){
        ArrayList<Predicate> result = new ArrayList<>();
        if (filter.getId() != null) {
            Predicate id = builder.equal(root.get("id"), filter.getId());
            result.add(id);
        }
        if(filter.getQuizName()!=null){
            Predicate quizName = builder.equal(root.get("quizName"), filter.getQuizName());
            result.add(quizName);
        }
        if(filter.getStartDate()!=null){
            Predicate startDate = builder.equal(root.get("startDate"), filter.getStartDate());
            result.add(startDate);
        }
        if(filter.getEndDate()!=null){
            Predicate endDate = builder.equal(root.get("endDate"), filter.getEndDate());
            result.add(endDate);
        }
        if(filter.getActive()!=null){
            Predicate active = builder.equal(root.get("active"), filter.getActive());
            result.add(active);
        }
        if(filter.getQuestionText()!=null){
            Predicate questionText =builder.equal(question.get("questionText"), filter.getQuestionText());
            result.add(questionText);
        }
        return result;
    }
}
