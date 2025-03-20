package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.model.TopicsModel;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    public Long createTopics(TopicsModel topicsModel) {
    return 1L;
    }

        @Autowired
        private TopicsRepository topicsRepository;

        public List<Topic> getAllTopics () {
            return topicsRepository.findAll();
        }

        public Optional<Topic> getTopic ( long topicId){
            return topicsRepository.findById(topicId);
        }

//        public List<Topic> getAllTopics () {
//            return topicsRepository.findAll();}
//


        public Long createTopic (TopicsModel topicsModel){
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


    }
