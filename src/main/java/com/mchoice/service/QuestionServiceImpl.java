package com.mchoice.service;

import com.mchoice.dao.QuestionDao;
import com.mchoice.model.McqQuestion;
import com.mchoice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao dao;

    @Autowired
    private UserService userService;

    @Override
    final public Question save(final Question question) {
        question.setCreatedBy(userService.getConnectedUser());
        return dao.save(question);
    }

    @Override
    final public Question find(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) dao.findAll();
    }

    @Override
    public List<Question> findAvailableQuestionFor(McqQuestion mcqQuestion) {
        return this.findAll();
    }
}
