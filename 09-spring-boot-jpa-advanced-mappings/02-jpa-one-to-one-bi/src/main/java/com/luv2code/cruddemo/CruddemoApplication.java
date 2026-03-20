package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
			//createInstructor(appDAO);
			//findInstructorById(appDAO);
			//deleteInstructorById(appDAO);
			//findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);
		};
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
