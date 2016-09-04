package com.mchoice.controller;

import com.mchoice.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oualid on 30/08/2016.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/connect/{userName}", method = RequestMethod.GET)
    public String connectAsTeacher(HttpServletRequest request, @PathVariable("userName") String userName){
        userService.connectAsTeacher(userName);
        return "redirect:/mcq";
    }

}
