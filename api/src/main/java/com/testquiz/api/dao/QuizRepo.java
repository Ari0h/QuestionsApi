package com.testquiz.api.dao;

import com.testquiz.api.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface QuizRepo extends CrudRepository<Quiz, Long> {

    Page<Quiz> findAll(Pageable pageable);

}
