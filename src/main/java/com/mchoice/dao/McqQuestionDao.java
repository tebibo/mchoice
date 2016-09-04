package com.mchoice.dao;

import com.mchoice.model.Mcq;
import com.mchoice.model.McqQuestion;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Oualid on 29/08/2016.
 */
@Transactional
public interface McqQuestionDao extends CrudRepository<McqQuestion, Long> {
}
