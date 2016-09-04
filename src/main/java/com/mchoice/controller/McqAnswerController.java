package com.mchoice.controller;

import com.mchoice.model.McqAnswer;
import com.mchoice.model.McqAnswer;
import com.mchoice.service.AnswerService;
import com.mchoice.service.McqAnswerService;
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
@RequestMapping("mcqAnswer")
public class McqAnswerController {

    @Autowired
    private McqAnswerService answerService;

    @RequestMapping(value = "/{mcqQuestionId}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("mcqQuestionId") Long mcqQuestionId){
        List<McqAnswer> answers = answerService.findAllByMcqQuestion(mcqQuestionId);
        model.addAttribute("answers", answers);

        return "answer/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") McqAnswer answer, BindingResult result){

        if(!result.hasErrors()){
            McqAnswer savedAnswer = answerService.save(answer);
        }

        return "redirect:/mcqQuestion/" + answer.getMcqQuestion().getId();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        answerService.delete(id);

        return "redirect:/answer";
    }
}
