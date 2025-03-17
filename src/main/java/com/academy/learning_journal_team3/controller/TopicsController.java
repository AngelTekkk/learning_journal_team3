package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.service.TeachingClassService;
import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/teachingClass/{teachingClassId}/topics")
@Controller
public class TopicsController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private TeachingClassService teachingClassService;

    @GetMapping()
    public String getTopics(Model model, @PathVariable(name="teachingClassId") Long teachingClassID){
        model.addAttribute("topics", topicsService.getAllTopics());
        model.addAttribute("teachingClass", teachingClassService.getTeachingClass(teachingClassID));
        return "topics";
    }

}

