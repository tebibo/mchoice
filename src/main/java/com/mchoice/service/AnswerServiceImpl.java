package com.mchoice.service;

import com.mchoice.dao.AnswerDao;
import com.mchoice.dao.QuestionDao;
import com.mchoice.model.Answer;
import com.mchoice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao dao;

    @Autowired
    private UserService userService;

    @Override
    final public Answer save(final Answer answer) {
        answer.setCreatedBy(userService.getConnectedUser());
        return dao.save(answer);
    }

    @Override
    final public Answer find(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Answer> findAll() {
        return (List<Answer>) dao.findAll();
    }
}
