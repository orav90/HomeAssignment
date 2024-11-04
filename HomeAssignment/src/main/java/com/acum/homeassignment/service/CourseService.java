package com.acum.homeassignment.service;

import com.acum.homeassignment.mapper.CourseMapper;
import com.acum.homeassignment.model.dto.CourseDTO;
import com.acum.homeassignment.model.dto.CourseWithStudentsDTO;
import com.acum.homeassignment.model.entity.Course;
import com.acum.homeassignment.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public CourseDTO courseToDTO(Course course) {
        return CourseMapper.INSTANCE.courseToCourseDTO(course);
    }

    public Course dtoToCourse(CourseDTO courseDTO) {
        return CourseMapper.INSTANCE.courseDTOToCourse(courseDTO);
    }

    public List<CourseWithStudentsDTO> getCoursesWithStudentCount() {
        return courseRepository.findCoursesWithStudentCount();
    }

}

