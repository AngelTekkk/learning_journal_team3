package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/topics")
@Controller
public class TopicController {

    @Autowired
    private TopicsService topicsService;

//    @GetMapping()
//    public String getTopics(Model model){
//        model.addAttribute("topic", topicsService.getAllTopics());
//        return "topics.html";
//    }

}
