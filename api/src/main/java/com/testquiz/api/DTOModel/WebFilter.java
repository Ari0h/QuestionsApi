package com.testquiz.api.DTOModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class WebFilter implements Serializable {

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

    @ApiModelProperty(notes = "Текст вопроса")
    @JsonProperty("question_text")
    private String questionText;

    @ApiModelProperty(notes = "Номер страницы")
    private Integer page;

    @ApiModelProperty(notes = "Количество элементов на странице")
    private Integer size;

    @ApiModelProperty(notes = "Поле сортировки. Поля перечисляются через ',' Порядок сортировки указывается '+' или '-' перед наименованием поля сортировки")
    private String sort;

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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getFirstResult(){
        return this.page*this.size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public WebFilter(){
    }
}
