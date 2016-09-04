package com.mchoice.service;

import com.mchoice.dao.McqQuestionDao;
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
public class McqQuestionServiceImpl implements McqQuestionService {

    @Autowired
    private McqQuestionDao dao;

    @Autowired
    private UserService userService;

    @Override
    final public McqQuestion save(final McqQuestion question) {
        return dao.save(question);
    }

    @Override
    final public McqQuestion find(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<McqQuestion> findAll() {
        return (List<McqQuestion>) dao.findAll();
    }
}
