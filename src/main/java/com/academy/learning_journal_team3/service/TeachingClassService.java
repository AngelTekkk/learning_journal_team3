package com.academy.learning_journal_team3.service;
import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.model.TeachingclassModel;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import com.academy.learning_journal_team3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeachingClassService {


    @Autowired
    private TeachingClassRepository teachingClassRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicsRepository topicsRepository;

    public List<TeachingClass> getAllTeachingClass() {
        return teachingClassRepository.findAll();
    }

    public TeachingClass getTeachingClass(Long teachingClassID) {
        return teachingClassRepository.findById(teachingClassID)
                .orElseThrow(() -> new NoSuchElementException("Klassenzimmer mit ID " + teachingClassID + " nicht gefunden"));
    }

    public List<TeachingClass> getAllClasses() {
        return teachingClassRepository.findAll();
    }

    public Long createTeachingClass(TeachingclassModel teachingclassModel) {
        for (TeachingClass currentTeachingClass : teachingClassRepository.findAll()) {
            if (currentTeachingClass.getName().equals(teachingclassModel.name())) {
                throw new RuntimeException("Klassenzimmer existiert bereits");
            }
        }
        TeachingClass teachingclass = teachingClassRepository.save(TeachingClass.builder()
                .name(teachingclassModel.name())
                .build());
        return teachingclass.getId();
    }

    public void updateTeachingClass(TeachingClass teachingClass) {
        teachingClassRepository.save(teachingClass);
    }

    @Transactional
    public void deleteTeachingClass(Long teachingClassId) {
        TeachingClass teachingClass = getTeachingClass(teachingClassId);

        List<User> users = teachingClass.getUserList();
        if (users != null) {
            for (User user : users) {
                user.setTeachingClass(null);
                userRepository.save(user);
            }
        }

        teachingClass.getTopicList().clear();
        teachingClassRepository.save(teachingClass);

        teachingClassRepository.deleteById(teachingClassId);
    }

    @Transactional
    public void addUserToClass(Long userId, Long classId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Benutzer mit ID " + userId + " nicht gefunden"));
        TeachingClass teachingClass = getTeachingClass(classId);

        user.setTeachingClass(teachingClass);
        userRepository.save(user);
    }

    @Transactional
    public void removeUserFromClass(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Benutzer mit ID " + userId + " nicht gefunden"));

        user.setTeachingClass(null);
        userRepository.save(user);
    }

    @Transactional
    public void addTopicToClass(Long classId, Long topicId) {
        TeachingClass teachingClass = getTeachingClass(classId);
        Topic topic = topicsRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Thema mit ID " + topicId + " nicht gefunden"));

        if (!teachingClass.getTopicList().contains(topic)) {
            teachingClass.getTopicList().add(topic);
            teachingClassRepository.save(teachingClass);
        }
    }

    @Transactional
    public void removeTopicFromClass(Long classId, Long topicId) {
        TeachingClass teachingClass = getTeachingClass(classId);
        Topic topic = topicsRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Thema mit ID " + topicId + " nicht gefunden"));

        teachingClass.getTopicList().remove(topic);
        teachingClassRepository.save(teachingClass);
    }
}