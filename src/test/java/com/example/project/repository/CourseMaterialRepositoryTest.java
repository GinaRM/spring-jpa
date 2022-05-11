package com.example.project.repository;

import com.example.project.entity.Course;
import com.example.project.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void SaveCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.net.com")
                        .course(course)
                        .build();
        repository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMateriasl = " + courseMaterials );
    }

}