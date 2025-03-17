package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.service.EntryService;
import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/teachingClass/{teachingClassId}/topics/{topicId}/entries")
@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private TopicsService topicsService;

    @GetMapping()
    public String getEntry(Model model, @PathVariable(name="topicId") Long topicID) {
        model.addAttribute("entries", entryService.getAllEntries());
        model.addAttribute("topic", topicsService.getTopic(topicID));

        return "entries";
    }
}




