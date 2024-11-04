package com.acum.homeassignment;

import com.acum.homeassignment.model.entity.Course;
import com.acum.homeassignment.model.entity.Student;
import com.acum.homeassignment.repository.CourseRepository;
import com.acum.homeassignment.repository.StudentRepository;
import com.acum.homeassignment.service.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    void testEnrollStudentTwiceAndValidateFullCourse() {

        Student student1 = new Student();
        student1.setFirstName("Student");
        student1.setLastName("A");
        studentRepository.save(student1);

        Course course = new Course();
        course.setMaxNumberOfStudents(3);
        courseRepository.save(course);

        studentService.enroll(student1.getId(), course.getId());

        Student savedStudent = studentRepository.findById(student1.getId()).orElseThrow();
        assertEquals(1, savedStudent.getCourses().size());
        assertEquals(course.getId(), savedStudent.getCourses().iterator().next().getId());
        assertThrows(RuntimeException.class, () -> studentService.enroll(student1.getId(), course.getId()));

        Student student2 = new Student();
        student2.setFirstName("Student");
        student2.setLastName("B");
        studentRepository.save(student2);

        Student student3 = new Student();
        student3.setFirstName("Student");
        student3.setLastName("C");
        studentRepository.save(student3);

        studentService.enroll(student2.getId(), course.getId());
        studentService.enroll(student3.getId(), course.getId());

        Course savedCourse = courseRepository.findById(course.getId()).orElseThrow();
        assertEquals(3, savedCourse.getStudents().size());
        assertThrows(RuntimeException.class, () -> studentService.enroll(4L, course.getId()));
    }
}
