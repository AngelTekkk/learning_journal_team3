package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.entity.TeachingClassTopic;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.repository.TeachingClassTopicRepository;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachingClassTopicService {

    @Autowired
    private TeachingClassTopicRepository teachingClassTopicRepository;

    @Autowired
    private TeachingClassRepository teachingClassRepository;

    @Autowired
    private TopicsRepository topicRepository;

    public void addTeachingClassTopic(Long teachingClassId, Long topicId) {
        TeachingClass teachingClass = teachingClassRepository.findById(teachingClassId)
                .orElseThrow(() -> new RuntimeException("TeachingClass not found"));
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        TeachingClassTopic teachingClassTopic = TeachingClassTopic.builder()
                .teachingClass(teachingClass)
                .topic(topic)
                .build();

        teachingClassTopicRepository.save(teachingClassTopic);
    }

    public void giveTopicsToUsers() {
        teachingClassRepository.findAll();
    }
}

