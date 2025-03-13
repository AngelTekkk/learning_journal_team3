package com.academy.learning_journal_team3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nutzer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "entries")
    @OneToMany(mappedBy = "user")
    private List<Entry> entryList;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private TeachingClass teachingClass;
}
