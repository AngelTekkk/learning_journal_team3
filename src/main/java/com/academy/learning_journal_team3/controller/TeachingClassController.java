package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.service.TeachingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/teachingClass")
@Controller
public class TeachingClassController {

    @Autowired
    private TeachingClassService teachingClassService;

    @GetMapping()
    public String getTeachingClass(Model model) {
        model.addAttribute("teachingClass", teachingClassService.getAllTeachingClass());
        return "teachingClass";
    }
}
