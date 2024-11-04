package com.acum.homeassignment.repository;

import com.acum.homeassignment.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s.first_name, s.last_name, c.id as course_id, c.description " +
            "FROM student s " +
            "LEFT JOIN enrollment e ON s.id = e.student_id " +
            "LEFT JOIN course c ON e.course_id = c.id " +
            "WHERE s.id = :studentId", nativeQuery = true)
    List<Object[]> findStudentWithCoursesById(@Param("studentId") Long studentId);

}

