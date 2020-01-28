package com.testquiz.api.service;

import com.testquiz.api.DTOModel.QuizDTO;
import com.testquiz.api.DTOModel.WebFilter;
import com.testquiz.api.dao.QuizDao;
import com.testquiz.api.model.Quiz;
import com.testquiz.api.utils.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("quizService")
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDao quizDao;

    @Override
    public Page<QuizDTO> getAllQuizes(WebFilter webFilter) {
        Page<Quiz> quizes = quizDao.getAllQuizes(webFilter);
        List<QuizDTO> quizesDTO = new ArrayList<>();
        for(Quiz quiz: quizes){
            QuizDTO quizDTO = new QuizDTO();
            ModelConverter.converterDBOtoDTOQuiz(quizDTO, quiz, webFilter);
            quizesDTO.add(quizDTO);
        }
        Page<QuizDTO> quizesPage = new PageImpl<>(quizesDTO);
        return quizesPage;
    }

    @Override
    @Transactional
    public void createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        ModelConverter.converterDTOtoDBOQuiz(quizDTO, quiz);
        quizDao.editQuiz(quiz);
    }

    @Override
    @Transactional
    public void editQuiz(QuizDTO quizDTO, Long id) {
        Quiz quiz = quizDao.getQuiz(id);
        ModelConverter.converterDTOtoDBOQuiz(quizDTO, quiz);
        quizDao.editQuiz(quiz);
    }

    @Override
    @Transactional
    public void deleteQuiz(Long quizId) {
        quizDao.deleteQuiz(quizId);
    }

    @Override
    @Transactional
    public QuizDTO getQuiz(Long quizId) {
        Quiz quiz = quizDao.getQuiz(quizId);
        QuizDTO quizDTO = new QuizDTO();
        ModelConverter.converterDBOtoDTOQuiz(quizDTO, quiz);
        return quizDTO;
    }


}
