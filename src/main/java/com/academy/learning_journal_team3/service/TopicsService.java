package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepository topicsRepository;

    public List<Topic> getAllTopics() {
        return topicsRepository.findAll();
    }

    public Optional<Topic> getTopic(long topicId){
        return topicsRepository.findById(topicId);
    }


}
