package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
            queryForStudents(studentDAO);
            deleteAll(studentDAO);
            queryForStudents(studentDAO);


        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all students ......");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted "+numRowsDeleted+" rows");

    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: "+studentId);
        studentDAO.delete(studentId);

    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id = "+studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student .....");
        myStudent.setFirstName("Milo");

        studentDAO.update(myStudent);
        System.out.println("Updated student: "+ myStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("rTestLastName");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for (Student s : theStudents) {
            System.out.println(s);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student studentC = new Student("rTest","rTestLastName","rTest@example.com");

        studentDAO.save(studentC);

        Student studentR = studentDAO.findById(studentC.getId());
        
        System.out.println(studentR);


    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new student object ...");

        Student tmpStudent1 = new Student("User1","LastName1","user1@example.com");
        Student tmpStudent2 = new Student("User1","LastName2","user2@example.com");
        Student tmpStudent3 = new Student("User2","LastName3","user3@example.com");

        System.out.println("Saving the students ...");

        studentDAO.save(tmpStudent1);
        studentDAO.save(tmpStudent2);
        studentDAO.save(tmpStudent3);

        System.out.println("Saved students. Generated id: " + tmpStudent1.getId()+", "+tmpStudent2.getId()+", "+tmpStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {

            System.out.println("Creating new student object ...");
            String studentName = "Adam";
            Student tmpStudent = new Student("Adam", "Mus", "adam@mus.pl");

            System.out.println("Saving the student ...");
            studentDAO.save(tmpStudent);

            System.out.println("Saved student. Generated id: " + tmpStudent.getId());

    }
}
