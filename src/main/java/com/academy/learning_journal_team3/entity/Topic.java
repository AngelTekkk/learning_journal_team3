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
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "topicList")
    private List<TeachingClass> teachingClasses;

    @OneToMany(mappedBy = "topic")
    private List<Entry> entryList;
}
