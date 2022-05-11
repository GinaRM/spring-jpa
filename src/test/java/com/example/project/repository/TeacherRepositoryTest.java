package com.example.project.repository;

import com.example.project.entity.Course;
import com.example.project.entity.Teacher;
import com.sun.jdi.PrimitiveValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseFrontend = Course
                .builder()
                .title("Frontend")
                .credit(5)
                .build();
        Course courseDB= Course
                .builder()
                .title("Data-Base")
                .credit(3)
                .build();
        Teacher teacher =  Teacher
                .builder()
                .firstName("Nicolas")
                .lastName("Lopez")
                //.courses(List.of(courseDB,courseFrontend))
                .build();
        teacherRepository.save(teacher);

    }

}