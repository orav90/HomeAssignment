package com.acum.homeassignment.controller;

import com.acum.homeassignment.service.CourseService;
import com.acum.homeassignment.model.dto.CourseWithStudentsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
    private CourseService courseService;

    @GetMapping("/student-count")
    public List<CourseWithStudentsDTO> getCoursesWithStudentCount() {
        return courseService.getCoursesWithStudentCount();
    }
}
