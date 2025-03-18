package com.academy.learning_journal_team3.model;

import lombok.Builder;

@Builder
public record UserModel(Long id, String firstname, String lastname, String username, String email, String password) {
}
