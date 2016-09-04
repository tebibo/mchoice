package com.mchoice.dao;

import com.mchoice.model.Mcq;
import com.mchoice.model.Question;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oualid on 29/08/2016.
 */
@Transactional
public interface McqDao extends CrudRepository<Mcq, Long> {
    List<Mcq> findByCreatedBy(String connectedUser);
}
