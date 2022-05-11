package com.example.project.repository;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher
                .builder()
                .firstName("Rogelio")
                .lastName("Martinez")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void finAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }
    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,2, Sort.by("Title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(0,2, Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2, Sort.by("title").descending()
                        .and(Sort.by("credit"))
                );
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }
    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "F",
                        firstPageTenRecords
                ).getContent();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher
                .builder()
                .firstName("Laura")
                .lastName("Perez")
                .build();

        Student student = Student
                .builder()
                .firstName("Alex")
                .lastName("Mejia")
                .emailId("alex@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("Data Science")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}
