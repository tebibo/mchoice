package com.mchoice.controller;

import com.mchoice.model.Question;
import com.mchoice.service.QuestionService;
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
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model){
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "question/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model){

        model.addAttribute("form", new Question());

        return "question/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") Question question, BindingResult result){
        Question savedQuestion = questionService.save(question);

        if(!result.hasErrors()){
            questionService.save(question);

            return "redirect:/question/" + savedQuestion.getId();
        }

        return "question/new";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) throws Exception {

        Question question = questionService.find(id);

        if(question == null){
            throw new Exception("Question does not exist");
        }

        model.addAttribute("form", question);

        return "/question/edit";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") Question question, BindingResult result, @PathVariable("id") Long id) throws Exception {

        if(!result.hasErrors()){
            Question savedQuestion = questionService.save(question);

            return "redirect:/question/" + savedQuestion.getId();
        }

        return "question/edit";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        questionService.delete(id);

        return "redirect:/question";
    }
}
