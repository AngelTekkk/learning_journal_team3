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
@Table(name = "teachingclass")
public class TeachingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "teachingClass")
    private List<User> userList;

//    @ManyToMany
//    @JoinTable(
//            name = "teachingClass_topic",
//            joinColumns = @JoinColumn(name = "teachingClass_id"),
//            inverseJoinColumns = @JoinColumn(name = "topic_id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"teaching_class_id", "topic_id"}),
//            indexes = @Index(columnList = "added_at")
//    )
//    @MapKeyColumn(name = "added_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private List<Topic> topicList;


    @OneToMany(mappedBy = "teachingClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingClassTopic> teachingClassTopics;

//    @ManyToMany
//    @JoinTable(
//            name = "teachingClass_topic",
//            joinColumns = @JoinColumn(name = "teachingClass_id"),
//            inverseJoinColumns = @JoinColumn(name = "topic_id")
//    )
//    private List<Topic> topicList;
}
