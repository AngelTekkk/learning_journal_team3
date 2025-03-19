package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.model.CustomUserDetails;
import com.academy.learning_journal_team3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Authentication authentication, Model model) {
        boolean isUsers = userService.getAllUsers().isEmpty();
        model.addAttribute("isUsers", isUsers);
        if (authentication != null) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            User currentUser = userService.findByEmail(userDetails.getUsername());
            model.addAttribute("user", currentUser);
            model.addAttribute("editMode", true);
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("editMode", false);
        }
//        boolean isAdmin = authentication != null &&
//                authentication.getAuthorities().stream()
//                        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//
//        model.addAttribute("isAdmin", isAdmin);

        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/welcome";
    }
}
