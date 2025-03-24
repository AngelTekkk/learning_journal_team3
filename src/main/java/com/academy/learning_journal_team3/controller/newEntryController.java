package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.repository.EntryRepository;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import com.academy.learning_journal_team3.service.TopicsService;
import com.academy.learning_journal_team3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("/teachingClass/${teachingClass.id}/topics/${topic.id}/entries/newEntry")
@Controller
public class newEntryController {
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TopicsRepository topicsRepository;
    @Autowired
    private TopicsService topicsService;
    @PostMapping("/newEntry")
    public String createNewEntry(
            Authentication authentication,
            @RequestParam(name="Entry", required=true) String formText,
            @RequestParam(name="Title", required=true) String formTitle,
            @RequestParam(name="Topics", required=true) String formTopicName,
            Model model){
        model.addAttribute("topics",topicsService.getAllTopics());
        User user  = userService.findByEmail(authentication.getName());
        Topic topic = topicsRepository.findByName(formTopicName);
        Entry newEntry = Entry.builder().content(formText).title(formTitle).user(user).topic(topic).build();
        entryRepository.save(newEntry);

        return "newEntry";
    }


}
