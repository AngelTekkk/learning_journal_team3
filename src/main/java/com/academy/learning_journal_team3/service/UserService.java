package com.academy.learning_journal_team3.service;

import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.model.UserModel;
import com.academy.learning_journal_team3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Integer createUser(UserModel usermodel){
        User user = userRepository.save(User.builder()
                .firstname(usermodel.firstname())
                .lastname(usermodel.lastname())
                .username(usermodel.username())
                .email(usermodel.email())
                .password(usermodel.password())
                .build());
        return user.getId();
    }
}
