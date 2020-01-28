package com.testquiz.api.DTOModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

    private Long id;

    @JsonProperty("quiz_id")
    private Long quizId;

    @JsonProperty("question_text")
    private String questionText;

    @JsonProperty("filter_number")
    private Long filterNumber;

    public QuestionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
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
}
