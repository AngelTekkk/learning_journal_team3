package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.repository.UserRepository;
import com.academy.learning_journal_team3.service.EntryService;
import com.academy.learning_journal_team3.service.TeachingClassService;
import com.academy.learning_journal_team3.service.TopicsService;
import com.academy.learning_journal_team3.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequestMapping("/teachingClass/{teachingClassId}/topics/{topicId}/entries")
@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private TopicsService topicsService;
    @Autowired
    private UserService userService;

    @Autowired
    private TeachingClassService teachingClassService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/entries")
    public String getEntries(Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);
        List<Entry> entries = entryService.getEntryByUser(user);
        model.addAttribute("entries", entries);
        return "entries";
    }

    @PostMapping("/entry/delete")
    public String deleteEntry(@RequestParam Long entryId, Authentication authentication) {
        Entry entry = entryService.getEntryById(entryId).get();
        if (entry.getUser().getEmail().equals(authentication.getName())) {
            entryService.deleteEntry(entryId);
            return "redirect:/entries";
        } else {
            return "error";
        }
    }

    @GetMapping("/newEntry/{id}")
    public String showEntryForUpdate(Model model, @PathVariable Long id) {
        Entry entry = entryService.getEntryById(id).get();
        model.addAttribute("entry", entry);
        model.addAttribute("topics", topicsService.getAllTopics());
        return "newEntry";
    }

    @GetMapping("/newEntry")
    public String getNewEntry(Model model) {
        model.addAttribute("topics",topicsService.getAllTopics());
        model.addAttribute("entry", new Entry());
        return "newEntry";
    }

}




