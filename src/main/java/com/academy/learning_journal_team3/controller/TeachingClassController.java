package com.academy.learning_journal_team3.controller;

import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.model.TeachingclassModel;
import com.academy.learning_journal_team3.service.TeachingClassService;
import com.academy.learning_journal_team3.service.UserService;
import com.academy.learning_journal_team3.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class TeachingClassController {

    @Autowired
    private TeachingClassService teachingClassService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicsService topicsService;


    @PostMapping("/createTeachingClass")
    public String createTeachingClass(@ModelAttribute TeachingclassModel teachingClassModel, RedirectAttributes redirectAttributes){
        try {
            Long teachingclassId = teachingClassService.createTeachingClass(teachingClassModel);
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

    @GetMapping("/admin/teachingClass/{id}")
    public String editTeachingClass(@PathVariable Long id, Model model) {
        TeachingClass teachingClass = teachingClassService.getTeachingClass(id);
        if (teachingClass != null) {
            List<User> allUsers = userService.getAllUsers();
            List<Topic> allTopics = topicsService.getAllTopics();

            List<User> availableUsers = userService.getUsersNotInClass(id);

            List<Topic> availableTopics = topicsService.getTopicsNotInClass(id);

            model.addAttribute("teachingClass", teachingClass);
            model.addAttribute("allUsers", allUsers);
            model.addAttribute("availableUsers", availableUsers);
            model.addAttribute("allTopics", allTopics);
            model.addAttribute("availableTopics", availableTopics);
            return "admin/edit-teachingClass";
        }
        return "redirect:/teachingClass";
    }

    @PostMapping("/admin/teachingClass/update")
    public String updateTeachingClass(@ModelAttribute TeachingClass teachingClass) {
        TeachingClass currentTeachingClass = teachingClassService.getTeachingClass(teachingClass.getId());
        if (currentTeachingClass != null) {
            currentTeachingClass.setName(teachingClass.getName());
            teachingClassService.updateTeachingClass(currentTeachingClass);
            return "redirect:/admin/teachingClass/" + currentTeachingClass.getId() + "?success";
        }
        return "redirect:/error";
    }

    @PostMapping("/teachingClass/delete")
    public String deleteTeachingClass(@RequestParam Long teachingClassId, RedirectAttributes redirectAttributes) {
        try {
            teachingClassService.deleteTeachingClass(teachingClassId);
            redirectAttributes.addFlashAttribute("successMessage", "Klassenzimmer erfolgreich gelöscht");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler beim Löschen des Klassenzimmers: " + e.getMessage());
        }
        return "redirect:/teachingClass";
    }

    @PostMapping("/admin/teachingClass/{classId}/addUser")
    public String addUserToClass(@PathVariable Long classId, @RequestParam Long userId, RedirectAttributes redirectAttributes) {
        try {
            teachingClassService.addUserToClass(userId, classId);
            redirectAttributes.addFlashAttribute("successMessage", "Benutzer erfolgreich zur Klasse hinzugefügt");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler beim Hinzufügen des Benutzers: " + e.getMessage());
        }
        return "redirect:/admin/teachingClass/" + classId;
    }

    @PostMapping("/admin/teachingClass/{classId}/removeUser")
    public String removeUserFromClass(@PathVariable Long classId, @RequestParam Long userId, RedirectAttributes redirectAttributes) {
        try {
            teachingClassService.removeUserFromClass(userId);
            redirectAttributes.addFlashAttribute("successMessage", "Benutzer erfolgreich aus der Klasse entfernt");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler beim Entfernen des Benutzers: " + e.getMessage());
        }
        return "redirect:/admin/teachingClass/" + classId;
    }

    @PostMapping("/admin/teachingClass/{classId}/addTopic")
    public String addTopicToClass(@PathVariable Long classId, @RequestParam Long topicId, RedirectAttributes redirectAttributes) {
        try {
            teachingClassService.addTopicToClass(classId, topicId);
            redirectAttributes.addFlashAttribute("successMessage", "Thema erfolgreich zur Klasse hinzugefügt");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler beim Hinzufügen des Themas: " + e.getMessage());
        }
        return "redirect:/admin/teachingClass/" + classId;
    }

    @PostMapping("/admin/teachingClass/{classId}/removeTopic")
    public String removeTopicFromClass(@PathVariable Long classId, @RequestParam Long topicId, RedirectAttributes redirectAttributes) {
        try {
            teachingClassService.removeTopicFromClass(classId, topicId);
            redirectAttributes.addFlashAttribute("successMessage", "Thema erfolgreich aus der Klasse entfernt");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Fehler beim Entfernen des Themas: " + e.getMessage());
        }
        return "redirect:/admin/teachingClass/" + classId;
    }
}

