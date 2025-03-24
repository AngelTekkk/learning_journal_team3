package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.model.TopicsModel;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicsService {

    public Long createTopics(TopicsModel topicsModel) {
    return 1L;
    }

    @Autowired
    private TopicsRepository topicsRepository;

    @Autowired
    private TeachingClassRepository teachingClassRepository;

    public List<Topic> getAllTopics () {
        return topicsRepository.findAll();
    }

//    public Optional<Topic> getTopic (Long topicId){
//        return topicsRepository.findById(topicId);
//    }

    public Topic getTopic(Long topicId) {
        return topicsRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("Thema mit ID " + topicId + " nicht gefunden"));
    }

    public Long createTopic (TopicsModel topicsModel){
        System.out.println(topicsModel.name());
        for (Topic currentTopic : topicsRepository.findAll()) {
            if (currentTopic.getName().equals(topicsModel.name())) {
                throw new RuntimeException("Thema existiert bereits");
            }
        }
        Topic topic = topicsRepository.save(Topic.builder()
                .name(topicsModel.name())
                .build());
        return topic.getId();
    }

    public List<Topic> getTopicsNotInClass(Long classId) {
        TeachingClass teachingClass = teachingClassRepository.findById(classId)
                .orElseThrow(() -> new NoSuchElementException("Klassenzimmer mit ID " + classId + " nicht gefunden"));

        List<Topic> classTopics = teachingClass.getTopicList();

        return topicsRepository.findAll().stream()
                .filter(topic -> !classTopics.contains(topic))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteTopic(Long topicId) {
        Topic topic = getTopic(topicId);

        for (TeachingClass teachingClass : topic.getTeachingClasses()) {
            teachingClass.getTopicList().remove(topic);
            teachingClassRepository.save(teachingClass);
        }

        topicsRepository.deleteById(topicId);
    }
}
