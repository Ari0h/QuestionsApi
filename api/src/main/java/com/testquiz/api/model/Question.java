package com.testquiz.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JsonProperty("quiz_id")
    @JoinColumn (name="quiz_id")
    private Quiz quiz;

    @JsonProperty("question_text")
    @Column(name = "question_text", nullable = false)
    private String questionText;

    @JsonProperty("filter_number")
    @Column(name = "filter_number")
    private Long filterNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getFilterNumber() {
        return filterNumber;
    }

    public void setFilterNumber(Long filterNumber) {
        this.filterNumber = filterNumber;
    }

    public Question() {
    }

//    public Question(Quiz quiz, String questionText, Long filterNumber) {
//        this.setQuiz(quiz);
//        this.setQuestionText(questionText);
//        this.setFilterNumber(filterNumber);
//    }

}
