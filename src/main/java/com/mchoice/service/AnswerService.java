package com.mchoice.service;

import com.mchoice.model.Answer;
import com.mchoice.model.Question;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface AnswerService {

    Answer save(Answer answer);

    Answer find(Long id);

    void delete(Long id);

    List<Answer> findAll();
}
