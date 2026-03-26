package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			
			//findInstructorById(appDAO);
			
			//deleteInstructorById(appDAO);
			
			//findInstructorDetailById(appDAO);
			
			//deleteInstructorDetailById(appDAO);

			//createInstructorWithCourses(appDAO);

			findInstructorWithCourses(appDAO);
		};
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " +tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);
		
		System.out.println("the associated courses: "+ tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructorToSave = new Instructor("Sebastian","Kot","seba@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com/@kfdpl","Board games"
		);

		instructorToSave.setInstructorDetail(instructorDetail);

		Course tempCourse1 = new Course("Bench Press Course");
		Course tempCourse2 = new Course("Squat Course");

		instructorToSave.add(tempCourse1);
		instructorToSave.add(tempCourse2);


		System.out.println("Saving instructor: " + instructorToSave);
		appDAO.save(instructorToSave);
		System.out.println("Done!");
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id = 3;
		InstructorDetail temp = appDAO.findInstructorDetailById(id);

		System.out.println(temp);
		Instructor instructor = temp.getInstructor();
		System.out.println(instructor);
		System.out.println("Done!");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructorById(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(1);
		if (instructor != null) {
			System.out.println(instructor);
			System.out.println("Done!");
		} else {
			System.err.println("Done!");
		}

	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructorToSave = new Instructor("Adam","Mus","adam@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube","Luv 2 code!!!"
		);
		instructorToSave.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructorToSave);
		appDAO.save(instructorToSave);
		System.out.println("Done!");
	}
}
