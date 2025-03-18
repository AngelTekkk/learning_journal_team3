package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("/teachingClass/${teachingClass.id}/topics/${topic.id}/entries/newEntry")
@Controller
public class newEntryController {
    @Autowired
    private EntryRepository entryRepository;

    @PostMapping("/newEntry")
    public String createNewEntry(
            @RequestParam(name="Entry", required=true) String formText,
            @RequestParam(name="Title", required=true) String formTitle,
            @RequestParam(name="UserId", required=true) User formUserId){
        Entry newEntry = Entry.builder().content(formText).title(formTitle).user(formUserId).build();
        entryRepository.save(newEntry);
        return "newEntry";
    }

}
