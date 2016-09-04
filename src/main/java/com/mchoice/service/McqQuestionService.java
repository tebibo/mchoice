package com.mchoice.service;

import com.mchoice.model.McqQuestion;
import com.mchoice.model.Question;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface McqQuestionService {

    McqQuestion save(McqQuestion question);

    McqQuestion find(Long id);

    void delete(Long id);

    List<McqQuestion> findAll();
}
