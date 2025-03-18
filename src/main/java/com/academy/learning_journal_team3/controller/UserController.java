package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/welcome";
    }
}
