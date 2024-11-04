package com.acum.homeassignment.service;

import com.acum.homeassignment.mapper.StudentMapper;
import com.acum.homeassignment.model.dto.CourseDTO;
import com.acum.homeassignment.model.dto.StudentDTO;
import com.acum.homeassignment.model.dto.StudentDetailsDTO;
import com.acum.homeassignment.model.entity.Course;
import com.acum.homeassignment.model.entity.Student;
import com.acum.homeassignment.repository.CourseRepository;
import com.acum.homeassignment.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentDetailsDTO studentToStudentDetailsDTO(Student student) {
        return StudentMapper.INSTANCE.studentToStudentDetailsDTO(student);
    }

    public Student studentDetailsDtoToStudent(StudentDetailsDTO student) {
        return StudentMapper.INSTANCE.studentDetailsDtoToStudent(student);
    }

    public List<StudentDetailsDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::studentToStudentDetailsDTO).toList();
    }


    public StudentDTO getStudentById(Long studentId) {
        List<Object[]> results = studentRepository.findStudentWithCoursesById(studentId);
        if (results.size() == 0) {
            throw new RuntimeException("Student not found");
        }

        StudentDTO studentDTO = null;
        Map<Long, CourseDTO> courseMap = new HashMap<>();

        for (Object[] row : results) {
            studentDTO = populateStudent(row);
            populateCourse(courseMap, row);
        }

        studentDTO.setCourses(new HashSet<>(courseMap.values()));
        return studentDTO;
    }

    private void populateCourse(Map<Long, CourseDTO> courseMap, Object[] row) {
        Long courseId = (Long) row[2];
        if (courseId != null && !courseMap.containsKey(courseId)) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setDescription((String) row[3]);
            courseMap.put(courseId, courseDTO);
        }
    }

    private StudentDTO populateStudent(Object[] row) {
        StudentDTO studentDTO;
        studentDTO = new StudentDTO();
        studentDTO.setFirstName((String) row[0]);
        studentDTO.setLastName((String) row[1]);
        return studentDTO;
    }


    public Student saveStudent(StudentDetailsDTO student) {
        return studentRepository.save(studentDetailsDtoToStudent(student));
    }

    public void updateStudent(Long id, StudentDetailsDTO studentDTO) {
        Student student = studentValidation(id);

        if (studentDTO.getFirstName() != null) {
            student.setFirstName(studentDTO.getFirstName());
        }
        if (studentDTO.getLastName() != null) {
            student.setLastName(studentDTO.getLastName());
        }

        studentRepository.save(student);
    }

    private Student studentValidation(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    private Course courseValidation(Long id, Long studentId) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (course.getStudents().stream().anyMatch(e -> Objects.equals(e.getId(), studentId))) {
            throw new RuntimeException("Student is already enrolled to this course");
        }

        if (course.getStudents().size() == course.getMaxNumberOfStudents()) {
            throw new RuntimeException("Course is full");
        }

        return course;
    }

    @Transactional
    public void enroll(Long studentId, Long courseId) {
        Student s = studentValidation(studentId);
        Course c = courseValidation(courseId, studentId);

        s.getCourses().add(c);
        c.getStudents().add(s);
        studentRepository.save(s);
    }
}

