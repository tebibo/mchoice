package com.mchoice.service;

import com.mchoice.model.Mcq;
import com.mchoice.model.Question;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface McqService {

    Mcq save(Mcq question);

    Mcq find(Long id);

    void delete(Long id);

    List<Mcq> findAll();

    List<Mcq> findByUser(String connectedUser);
}
