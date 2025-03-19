package com.academy.learning_journal_team3;

import com.academy.learning_journal_team3.entity.Entry;
import com.academy.learning_journal_team3.entity.TeachingClass;
import com.academy.learning_journal_team3.entity.Topic;
import com.academy.learning_journal_team3.entity.User;
import com.academy.learning_journal_team3.repository.EntryRepository;
import com.academy.learning_journal_team3.repository.TeachingClassRepository;
import com.academy.learning_journal_team3.repository.TopicsRepository;
import com.academy.learning_journal_team3.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningJournalTeam3Application {

	public static void main(String[] args) throws Throwable {
		SpringApplication.
				run(LearningJournalTeam3Application.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(TeachingClassRepository teachingClassRepository, UserRepository userRepository, TopicsRepository topicsRepository, EntryRepository entryRepository){
//		return (args) -> {
//			System.out.println("Hallöchen");
//
//
//			TeachingClass teachingClass1 = TeachingClass.builder().name("Schulklasse 1").build();
//			TeachingClass teachingClass2 = TeachingClass.builder().name("Schulklasse 2").build();
//			TeachingClass teachingClass3 = TeachingClass.builder().name("Schulklasse 3").build();
//			teachingClassRepository.save(teachingClass1);
//			teachingClassRepository.save(teachingClass2);
//			teachingClassRepository.save(teachingClass3);
//
//
//			User user1 = User.builder().firstName("Markus").teachingClass(teachingClass1).build();  // builder erstetzt die hartgecodete Variante mit der erstellung der Liste
//			userRepository.save(user1);
//			User user2 = User.builder().firstName("Lisa").teachingClass(teachingClass1).build();
//			userRepository.save(user2);
//			User user3 = User.builder().firstName("Verona").teachingClass(teachingClass2).build();
//			userRepository.save(user3);
//			User user4 = User.builder().firstName("Paul").teachingClass(teachingClass3).build();
//			userRepository.save(user4);
//
//
//			Topic topic1 = Topic.builder().name("SQL").build();
//			Topic topic2 = Topic.builder().name("Java").build();
//			Topic topic3 = Topic.builder().name("BWL").build();
//			Topic topic4 = Topic.builder().name("Netzwerktechnik").build();
//			topicsRepository.save(topic1);
//			topicsRepository.save(topic2);
//			topicsRepository.save(topic3);
//			topicsRepository.save(topic4);
//
//		};
//	}
}


