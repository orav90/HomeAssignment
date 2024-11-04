package com.acum.homeassignment.repository;

import com.acum.homeassignment.model.dto.CourseWithStudentsDTO;
import com.acum.homeassignment.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT new com.acum.homeassignment.model.dto.CourseWithStudentsDTO(c.description, COUNT(s)) " +
            "FROM Course c " +
            "LEFT JOIN c.students s " +
            "GROUP BY c.description, c.maxNumberOfStudents")
    List<CourseWithStudentsDTO> findCoursesWithStudentCount();

}




