package com.testquiz.api.controller;

import com.testquiz.api.DTOModel.QuizDTO;
import com.testquiz.api.DTOModel.WebFilter;
import com.testquiz.api.service.QuizService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(value="Quiz controller")
@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;
    @ApiOperation(value = "Отображение списка всех элементов")
    @RequestMapping(method = RequestMethod.POST, value ="/getall", produces = "application/json")
    public Page<QuizDTO> getAllQuizes(@RequestBody WebFilter webFilter) {
        return quizService.getAllQuizes(webFilter);
    }

    @ApiOperation(value = "Создание нового опроса")
    @RequestMapping(method = RequestMethod.POST, value = "/quiz", produces = "application/json")
    public void addQuiz(@RequestBody QuizDTO quiz){
        quizService.createQuiz(quiz);
    }

    @ApiOperation(value = "Получение опроса по его id")
    @RequestMapping(method = RequestMethod.GET, value ="/quiz/{id}", produces = "application/json")
    public QuizDTO getQuizById(@PathVariable Long id){
       return quizService.getQuiz(id);
    }

    @ApiOperation(value = "Редактирование опроса")
    @RequestMapping(method = RequestMethod.PUT, value = "/quiz/{id}", produces = "application/json")
    public void updateQuiz(@RequestBody QuizDTO quizDTO, @PathVariable Long id){
        quizService.editQuiz(quizDTO, id);
    }

    @ApiOperation(value = "Удаление опроса")
    @RequestMapping(method = RequestMethod.DELETE, value = "/quiz/{id}", produces = "application/json")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }
}
