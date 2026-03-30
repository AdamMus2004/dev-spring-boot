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
			//createCourseAndStudent(appDAO);
			//findCourseAndStudent(appDAO);
			//findStudentAndCourse(appDAO);
			updateStudent(appDAO);

		};
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 2;

		Student student = appDAO.findStudentAndCoursesByCourseId(theId);

		System.out.println("Loaded Student: " + student);
		System.out.println("Course: " +student.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theId = 10;

		Course course = appDAO.findCourseAndStudentsByCourseId(theId);




		System.out.println("Done!");
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course course1 = new Course("Java/Spring Boot - course");


		Student student1 = new Student("Adam", "Mus", "adam@example.com");
		Student student2 = new Student("Julia", "Wilczynska", "julia@example.com");


		course1.addStudent(student1);
		course1.addStudent(student2);



		appDAO.save(course1);


		System.out.println("Done!");
	}
}