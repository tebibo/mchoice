package com.mchoice.dao;

import com.mchoice.model.Question;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Oualid on 29/08/2016.
 */
@Transactional
public interface QuestionDao extends CrudRepository<Question, Long> {
}
