package com.acum.homeassignment.controller;

import com.acum.homeassignment.service.StudentService;
import com.acum.homeassignment.model.dto.StudentDTO;
import com.acum.homeassignment.model.dto.StudentDetailsDTO;
import com.acum.homeassignment.model.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDetailsDTO>> getAllStudents() {
        try {
            return ResponseEntity.ok(studentService.getAllStudents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDetailsDTO studentDetails) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(studentDetails));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDetailsDTO student) {
        try {
            studentService.updateStudent(id, student);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public void enrollToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enroll(studentId, courseId);
    }


}
