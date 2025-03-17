package com.academy.learning_journal_team3.service;
import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.model.TeachingclassModel;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TeachingClassService {


    @Autowired
    private TeachingClassRepository teachingClassRepository;

    public List<TeachingClass> getAllTeachingClass() {
        return teachingClassRepository.findAll();
    }

    public TeachingClass getTeachingClass(Long teachingClassID){
        return teachingClassRepository.findById(teachingClassID).get();
    }

    public List<TeachingClass> getAllClasses() {
        return teachingClassRepository.findAll();
    }

    public Long createTeachingclass(TeachingclassModel teachingclassModel){
        for(TeachingClass currentTeachingClass : teachingClassRepository.findAll()){
            if(currentTeachingClass.getName().equals(teachingclassModel.name())){
                throw new RuntimeException("Klassenzimmer existiert bereits");
            }
        }
        TeachingClass teachingclass = teachingClassRepository.save(TeachingClass.builder()
                .name(teachingclassModel.name())
                .build());
        return teachingclass.getId();
    }

}