package com.mchoice.controller;

import com.mchoice.model.Mcq;
import com.mchoice.model.McqQuestion;
import com.mchoice.service.McqService;
import com.mchoice.service.UserService;
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
@RequestMapping("mcq")
public class McqController {

    @Autowired
    private McqService mcqService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model){
        List<Mcq> mcqs = mcqService.findByUser(userService.getConnectedUser());
        model.addAttribute("mcqs", mcqs);

        return "mcq/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model){
        Mcq mcq = new Mcq();

        mcq.setCreatedBy(userService.getConnectedUser());

        model.addAttribute("form", mcq);

        return "mcq/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") Mcq mcq, BindingResult result){

        if(!result.hasErrors()){
            Mcq savedMcq = mcqService.save(mcq);

            return "redirect:/mcq/" + savedMcq.getId();
        }

        return "mcq/new";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) throws Exception {

        Mcq mcq = mcqService.find(id);

        if(mcq == null){
            throw new Exception("Mcq does not exist");
        }

        model.addAttribute("form", mcq);

        return "/mcq/edit";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("form") Mcq mcq, BindingResult result, @PathVariable("id") Long id) throws Exception {
        Mcq savedMcq = mcqService.save(mcq);

        if(!result.hasErrors()){
            mcqService.save(mcq);

            return "redirect:/mcq/" + savedMcq.getId();
        }

        return "mcq/edit";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        mcqService.delete(id);

        return "redirect:/mcq";
    }
}
