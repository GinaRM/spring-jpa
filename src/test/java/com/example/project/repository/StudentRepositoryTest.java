package com.example.project.repository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.project.entity.Guardian;
import com.example.project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void  saveStudent() {
        Student student = Student.builder()
                .emailId("gina@gmail.com")
                .firstName("Gina")
                .lastName("Rodriguez")
                //.guardianName("Maria")
                //.guardianEmail("maria@gmail.com")
                //.guardianPhone("3001112223")
                .build();
        studentRepository.save(student);

        }
        @Test
        public void saveStudentWithGuardian () {
            Guardian guardian = Guardian.builder()
                    .name("Maria")
                    .email("maria@gmail.com")
                    .phone("3001112223")
                    .build();

                Student student = Student.builder()
                        .firstName("Paola")
                        .emailId("paola@gmail.com")
                        .lastName("Rodriguez")
                        .guardian(guardian)
                        .build();
                studentRepository.save(student);
        }
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList =" + studentList);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Paola");
        System.out.println("students =" + students);

    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("g");
        System.out.println("students =" + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Maria");
        System.out.println("students =" + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress(
                "gina@gmail.com"
        );
        System.out.println("students =" + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
       String firstName = studentRepository.getStudentFirstNameByEmailAddress(
                "paola@gmail.com"
        );
        System.out.println("FirstName =" + firstName);
    }

    @Test
    public void printetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative(
                "gina@gmail.com"
        );
        System.out.println("student =" + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "gina@gmail.com"
        );
        System.out.println("student =" + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Gina Paola",
                "gina@gmail.com"
        );
    }





}