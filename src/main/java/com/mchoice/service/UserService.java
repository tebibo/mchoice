package com.mchoice.service;

/**
 * Created by Oualid on 30/08/2016.
 */
public interface UserService {

    String getConnectedUser();

    String connectAsStudent(String studName);

    String connectAsTeacher(String teacherName);

}
