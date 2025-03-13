package com.academy.learning_journal_team3.service;
import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachingClassService {


    @Autowired
    private TeachingClassRepository teachingClassRepository;

    public List<TeachingClass> getAllTeachingClass() {
        return teachingClassRepository.findAll();
    }

    public Optional<TeachingClass> getTeachingClassId(long teachingClassID){
        return teachingClassRepository.findById(teachingClassID);
    }
}