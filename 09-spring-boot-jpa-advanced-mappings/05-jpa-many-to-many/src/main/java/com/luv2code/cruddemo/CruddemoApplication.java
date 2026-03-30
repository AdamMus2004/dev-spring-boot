package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createCourseAndStudent(appDAO);
		};
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course course1 = new Course("Java/Spring Boot - course");
//		Course course2 = new Course("Python/Fast API - course");
//		Course course3 = new Course("Cooking/Bakery - course");

		Student student1 = new Student("Adam", "Mus", "adam@example.com");
		Student student2 = new Student("Julia", "Wilczynska", "julia@example.com");


		course1.addStudent(student1);
		course1.addStudent(student2);
//		course2.addStudent(student1);
//		course3.addStudent(student1);
//		course3.addStudent(student2);


		appDAO.save(course1);
//		appDAO.save(course2);
//		appDAO.save(course3);

		System.out.println("Done!");
	}
}