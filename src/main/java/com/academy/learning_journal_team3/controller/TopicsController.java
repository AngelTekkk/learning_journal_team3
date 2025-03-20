package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.service.TeachingClassService;
import com.academy.learning_journal_team3.service.TopicsService;
import com.academy.learning_journal_team3.model.TopicsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class TopicsController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private TeachingClassService teachingClassService;


    @PostMapping("/createTopics")
    public String createTopics(@ModelAttribute TopicsModel topicsModel, RedirectAttributes redirectAttributes){
        try {
            Long topicsId = topicsService.createTopic(topicsModel);
            redirectAttributes.addAttribute("id", topicsId);
            redirectAttributes.addFlashAttribute("id", topicsId);
            redirectAttributes.addFlashAttribute("successMessage", "Thema erstellt");
            return "redirect:/Topics";

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return"redirect:Topics";
        }

    }

    @GetMapping("/topics")
    public String getTopics(Model model){
        model.addAttribute("topics", topicsService.getAllTopics());
//        model.addAttribute("teachingClass", teachingClassService.getTeachingClass(teachingClassID));
        return "topics";
    }

}

