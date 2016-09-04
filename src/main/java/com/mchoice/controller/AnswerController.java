package com.mchoice.controller;

import com.mchoice.model.Answer;
import com.mchoice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Oualid on 29/08/2016.
 */
@Controller
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model){
        List<Answer> answers = answerService.findAll();
        model.addAttribute("answers", answers);

        return "answer/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model){

        model.addAttribute("form", new Answer());

        return "answer/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") Answer answer, BindingResult result){


        if(!result.hasErrors()){
            Answer savedAnswer = answerService.save(answer);

            return "redirect:/answer/" + savedAnswer.getId();
        }

        return "answer/new";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) throws Exception {

        Answer answer = answerService.find(id);

        if(answer == null){
            throw new Exception("Answer does not exist");
        }

        model.addAttribute("form", answer);

        return "/answer/edit";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") Answer answer, BindingResult result, @PathVariable("id") Long id) throws Exception {
        Answer savedAnswer = answerService.save(answer);

        if(!result.hasErrors()){
            answerService.save(answer);

            return "redirect:/answer/" + savedAnswer.getId();
        }

        return "answer/edit";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        answerService.delete(id);

        return "redirect:/answer";
    }
}
