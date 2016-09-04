package com.mchoice.service;

import org.springframework.stereotype.Service;

/**
 * Created by Oualid on 30/08/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private String connectedUser = "defaultTeacher";


    @Override
    public String getConnectedUser() {
        return connectedUser;
    }

    @Override
    public String connectAsStudent(String studName) {
        return connectedUser = studName;
    }

    @Override
    public String connectAsTeacher(String teacherName) {
        return connectedUser = teacherName;
    }
}
