package com.mchoice.service;

import com.mchoice.dao.AnswerDao;
import com.mchoice.dao.McqAnswerDao;
import com.mchoice.model.Answer;
import com.mchoice.model.McqAnswer;
import com.mchoice.model.McqQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Service
public class McqAnswerServiceImpl implements McqAnswerService {

    @Autowired
    private McqAnswerDao dao;

    @Autowired
    private McqQuestionService mcqQuestionService;

    @Override
    final public McqAnswer save(final McqAnswer answer) {
        return dao.save(answer);
    }

    @Override
    final public McqAnswer find(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<McqAnswer> findAll() {
        return (List<McqAnswer>) dao.findAll();
    }

    @Override
    public List<McqAnswer> findAllByMcqQuestion(Long mcqQuestionId) {
        McqQuestion question = mcqQuestionService.find(mcqQuestionId);

        return dao.findByMcqQuestion(question);
    }
}
