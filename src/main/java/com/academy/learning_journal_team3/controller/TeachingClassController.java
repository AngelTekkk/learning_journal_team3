package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.model.TeachingclassModel;
import com.academy.learning_journal_team3.service.TeachingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class TeachingClassController {

    @Autowired
    private TeachingClassService teachingClassService;


    @PostMapping("/createTeachingClass")
    public String createTeachingClass(@ModelAttribute TeachingclassModel teachingClassModel, RedirectAttributes redirectAttributes){
        try {
            Long teachingclassId = teachingClassService.createTeachingclass(teachingClassModel);
            redirectAttributes.addAttribute("id", teachingclassId);
            redirectAttributes.addFlashAttribute("id", teachingclassId);
            redirectAttributes.addFlashAttribute("successMessage", "Klassenzimmer erstellt :)");
            return "redirect:/teachingClass";

        } catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/teachingClass";
        }

    }

    @GetMapping("/teachingClass")
    public String teachingClasses(Model model) {
        List<TeachingClass> allTeachingClasses = teachingClassService.getAllClasses();
        model.addAttribute("teachingClass", allTeachingClasses);
        return "teachingClass";
    }
}
