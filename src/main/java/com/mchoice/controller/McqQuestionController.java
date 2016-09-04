package com.mchoice.controller;

import com.mchoice.model.Answer;
import com.mchoice.model.McqAnswer;
import com.mchoice.model.McqQuestion;
import com.mchoice.model.Question;
import com.mchoice.service.AnswerService;
import com.mchoice.service.McqQuestionService;
import com.mchoice.service.McqService;
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
@RequestMapping("mcqQuestion")
public class McqQuestionController {

    @Autowired
    private McqQuestionService mcqQuestionService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private McqService mcqService;

    @RequestMapping(value = "/new/{mcqId}", method = RequestMethod.GET)
    public String create(@PathVariable("mcqId") Long mcqId, Model model){
        McqQuestion mcqQuestion = new McqQuestion();
        mcqQuestion.setMcq(mcqService.find(mcqId));

        List<Question> availableQuestions = questionService.findAvailableQuestionFor(mcqQuestion);
        model.addAttribute("questions", availableQuestions);
        model.addAttribute("form", mcqQuestion);

        return "mcqQuestion/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") McqQuestion mcqQuestion, BindingResult result){

        if(!result.hasErrors()){
            McqQuestion savedQuestion = mcqQuestionService.save(mcqQuestion);

            return "redirect:/mcqQuestion/" + savedQuestion.getId();
        }

        return "mcqQuestion/new";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) throws Exception {

        McqQuestion mcqQuestion = mcqQuestionService.find(id);

        if(mcqQuestion == null){
            throw new Exception("McqQuestion does not exist");
        }

        List<Answer> availableAnswers = answerService.findAll();
        McqAnswer answerForm = new McqAnswer();
        answerForm.setMcqQuestion(mcqQuestion);

        model.addAttribute("availableAnswers", availableAnswers);
        model.addAttribute("mcqQuestion", mcqQuestion);
        model.addAttribute("answerForm", answerForm);

        return "/mcqQuestion/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") McqQuestion mcqQuestion, BindingResult result, @PathVariable("id") Long id) throws Exception {

        if(!result.hasErrors()){
            McqQuestion savedQuestion = mcqQuestionService.save(mcqQuestion);

            return "redirect:/mcqQuestion/" + savedQuestion.getId();
        }

        return "mcqQuestion/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        mcqQuestionService.delete(id);

        return "redirect:/mcqQuestion";
    }
}
