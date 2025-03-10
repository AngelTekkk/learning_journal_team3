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
@Table(name = "teachingclass")
public class TeachingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "users")
    @OneToMany(mappedBy = "teachingClass")
    private List<User> userList;

    @ManyToMany
    @JoinTable(
            name = "teachingClass_topic",
            joinColumns = @JoinColumn(name = "teachingClass_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topicList;
}
