package com.testquiz.api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "quizes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quiz_name", unique = true, nullable = false)
    private String quizName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "quiz",
            cascade = CascadeType.ALL)
    private Set<Question> questions;

    public Quiz() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Quiz clone(Quiz quiz){
        this.setQuizName(quiz.getQuizName());
        this.setStartDate(quiz.getStartDate());
        this.setEndDate(quiz.getEndDate());
        this.setActive(quiz.getActive());
        this.getQuestions().clear();
        this.getQuestions().addAll(quiz.getQuestions());
          return this;
    }
}
