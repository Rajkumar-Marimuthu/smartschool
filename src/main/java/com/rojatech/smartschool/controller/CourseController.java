package com.rojatech.smartschool.controller;

import com.rojatech.smartschool.dto.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    private static final List<Course> courses = Arrays.asList(
            Course.builder().subject("Artificial Intelligence").build(),
            Course.builder().subject("Spring").build(),
            Course.builder().subject("React").build(),
            Course.builder().subject("Python").build(),
            Course.builder().subject("Kafka").build()
    );

    @GetMapping("/course")
    public Flux<Course> getCourses() {
        return Flux.fromIterable(courses);
    }
}
