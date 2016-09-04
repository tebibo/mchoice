package com.mchoice.service;

import com.mchoice.dao.McqDao;
import com.mchoice.model.Mcq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Service
public class McqServiceImpl implements McqService {

    @Autowired
    private McqDao dao;

    @Autowired
    private UserService userService;

    @Override
    final public Mcq save(final Mcq mcq) {
        mcq.setCreatedBy(userService.getConnectedUser());
        return dao.save(mcq);
    }

    @Override
    final public Mcq find(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Mcq> findAll() {
        return (List<Mcq>) dao.findAll();
    }

    @Override
    public List<Mcq> findByUser(String connectedUser) {
        return dao.findByCreatedBy(connectedUser);
    }
}
