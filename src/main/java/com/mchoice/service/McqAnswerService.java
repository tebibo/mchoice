package com.mchoice.service;

import com.mchoice.model.Answer;
import com.mchoice.model.McqAnswer;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface McqAnswerService {

    McqAnswer save(McqAnswer answer);

    McqAnswer find(Long id);

    void delete(Long id);

    List<McqAnswer> findAll();

    List<McqAnswer> findAllByMcqQuestion(Long mcqQuestionId);
}
