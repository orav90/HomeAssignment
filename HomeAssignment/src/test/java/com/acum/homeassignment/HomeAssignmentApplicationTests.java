package com.acum.homeassignment;

import com.acum.homeassignment.model.entity.Course;
import com.acum.homeassignment.model.entity.Student;
import com.acum.homeassignment.repository.CourseRepository;
import com.acum.homeassignment.repository.StudentRepository;
import com.acum.homeassignment.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class HomeAssignmentApplicationTests {

	@Mock
	private StudentRepository studentRepository;

	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private StudentService studentService;

	private Student student;
	private Course course;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		student = new Student();
		student.setId(1L);
		student.setFirstName("Benny");
		student.setLastName("Goren");

		course = new Course();
		course.setId(1L);
		course.setMaxNumberOfStudents(3);
		course.setDescription("Math");
	}

	@Test
	void testEnrollStudentTwice() {
		when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));
		when(courseRepository.findById(any(Long.class))).thenReturn(Optional.of(course));

		studentService.enroll(2L, course.getId());
		studentService.enroll(3L, course.getId());
		studentService.enroll(4L, course.getId());

		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			studentService.enroll(student.getId(), course.getId());
			studentService.enroll(student.getId(), course.getId());
		});



	}

}
