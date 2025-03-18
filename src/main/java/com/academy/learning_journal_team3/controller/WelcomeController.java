package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcomePage(Model model, Authentication authentication){
        String email = authentication.getName();
        User user = userService.findByEmail(email);

        System.out.println("User found: " + user); // Проверяем, существует ли пользователь
        if (user != null) {
            System.out.println("User firstName: " + user.getFirstName());
            System.out.println("User lastName: " + user.getLastName());
        }

        model.addAttribute("user", user);
        return "welcome";
    }
}
