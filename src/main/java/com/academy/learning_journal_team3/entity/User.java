package com.academy.learning_journal_team3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "forgot_password")
    private boolean forgotPassword;

    @Column(name = "role")
    private String role; // ADMIN, USER

    @OneToMany(mappedBy = "user")
    private List<Entry> entryList;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private TeachingClass teachingClass;

    @PrePersist
    protected void onCreate() {
        this.forgotPassword = false;
    }
}
