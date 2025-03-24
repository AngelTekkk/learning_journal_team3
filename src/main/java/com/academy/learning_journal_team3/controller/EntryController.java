package com.academy.learning_journal_team3.controller;


import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.service.EntryService;
import com.academy.learning_journal_team3.service.TeachingClassService;
import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



//@RequestMapping("/teachingClass/{teachingClassId}/topics/{topicId}/entries")
@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private TeachingClassService teachingClassService;

    @GetMapping("/entries")
    public String getEntries(Model model, @PathVariable(name="topicId") Long topicID, @PathVariable(name="teachingClassId") Long teachingClassID) {
        model.addAttribute("entries", entryService.getAllEntries());
//        model.addAttribute("topic", topicsService.getTopic(topicID).get());
        model.addAttribute("teachingClass", teachingClassService.getTeachingClass(teachingClassID));
        return "entries";
    }

//    @GetMapping("/newEntry")
//    public String showNewEntryPage(Model model, @PathVariable(name="topicId") Long topicID, @PathVariable(name="teachingClassId") Long teachingClassID) {
//        model.addAttribute("topic", topicsService.getTopic(topicID).get());
//        model.addAttribute("teachingClass", teachingClassService.getTeachingClass(teachingClassID));
//        return "newEntry";
//    }

    @GetMapping("/newEntry")
    public String getNewEntry(Model model) {
        model.addAttribute("entry", new Entry());
        return "newEntry";
    }

}




