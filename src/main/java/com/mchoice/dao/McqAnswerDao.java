package com.mchoice.dao;

import com.mchoice.model.McqAnswer;
import com.mchoice.model.McqQuestion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oualid on 29/08/2016.
 */
@Transactional
public interface McqAnswerDao extends CrudRepository<McqAnswer, Long> {

    List<McqAnswer> findByMcqQuestion(McqQuestion question);
}
