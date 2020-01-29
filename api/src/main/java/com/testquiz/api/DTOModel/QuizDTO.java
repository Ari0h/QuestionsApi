package com.testquiz.api.DTOModel;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class QuizDTO implements Serializable {

    @ApiModelProperty(notes = "Идентификатор опроса")
    private Long id;

    @ApiModelProperty(notes = "Название опроса")
    private String quizName;

    @ApiModelProperty(notes = "Дата начала опроса")
    private Date startDate;

    @ApiModelProperty(notes = "Дата окончания опроса")
    private Date endDate;

    @ApiModelProperty(notes = "Признак активности опроса")
    private Boolean active;

    @ApiModelProperty(notes = "Список вопросов, относящихся к вопросу")
    private Set<QuestionDTO> questions;

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

    public Set<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionDTO> questions) {
        this.questions = questions;
    }

    public QuizDTO() {
    }
}
