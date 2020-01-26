package com.testquiz.api.controller;

import com.testquiz.api.DTOModel.QuizDTO;
import com.testquiz.api.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @RequestMapping("/getall")
    public List<QuizDTO> getAllQuizes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
         List<QuizDTO> result = quizService.getAllQuizes(pageable);
         return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/quiz")
    public void addQuiz(@RequestBody QuizDTO quiz){
        quizService.createQuiz(quiz);
    }

    @RequestMapping("/quiz/{id}")
    public QuizDTO getQuizById(@PathVariable Long id){
       return quizService.getQuiz(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/quiz/{id}")
    public void updateQuiz(@RequestBody QuizDTO quizDTO, @PathVariable Long id){
        quizService.editQuiz(quizDTO, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/quiz/{id}")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }
}
