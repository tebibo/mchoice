package com.mchoice.service;

import com.mchoice.model.McqQuestion;
import com.mchoice.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface QuestionService {

    Question save(Question question);

    Question find(Long id);

    void delete(Long id);

    List<Question> findAll();

    List<Question> findAvailableQuestionFor(McqQuestion mcqQuestion);
}
