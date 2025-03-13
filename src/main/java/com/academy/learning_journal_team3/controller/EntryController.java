package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.service.EntryService;
import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/entries")
@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private TopicsService topicsService;

    @GetMapping()
    public String getEntry(Model model) {
        Entry entry1 = new Entry(1L, null, "SQL", "BLABLA", null);
        Entry entry2 = new Entry(2L, null, "Java", "BLABLA", null);
//        model.addAttribute("entry", entryService.getAllEntries());
        model.addAttribute("entry", List.of(entry1, entry2));
        model.addAttribute("topicName", topicsService.getTopicName(1L));
        return "entries";
    }
}




