package com.testquiz.api.DTOModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

    @ApiModelProperty(notes = "Идентификатор вопроса")
    private Long id;

    @ApiModelProperty(notes = "Идентификатор для связи с просом ")
    @JsonProperty("quiz_id")
    private Long quizId;

    @ApiModelProperty(notes = "Текст вопроса")
    @JsonProperty("question_text")
    private String questionText;

    @ApiModelProperty(notes = "Порядковый номер вопроса в списке вопросов.")
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
