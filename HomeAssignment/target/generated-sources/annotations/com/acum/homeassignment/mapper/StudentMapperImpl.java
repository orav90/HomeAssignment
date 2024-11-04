package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.CourseDTO;
import com.acum.homeassignment.model.dto.StudentDTO;
import com.acum.homeassignment.model.dto.StudentDetailsDTO;
import com.acum.homeassignment.model.entity.Course;
import com.acum.homeassignment.model.entity.Student;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-04T20:20:18+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setFirstName( student.getFirstName() );
        studentDTO.setLastName( student.getLastName() );
        studentDTO.setCourses( courseSetToCourseDTOSet( student.getCourses() ) );

        return studentDTO;
    }

    @Override
    public Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setFirstName( studentDTO.getFirstName() );
        student.setLastName( studentDTO.getLastName() );
        student.setCourses( courseDTOSetToCourseSet( studentDTO.getCourses() ) );

        return student;
    }

    @Override
    public StudentDetailsDTO studentToStudentDetailsDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDetailsDTO studentDetailsDTO = new StudentDetailsDTO();

        studentDetailsDTO.setFirstName( student.getFirstName() );
        studentDetailsDTO.setLastName( student.getLastName() );

        return studentDetailsDTO;
    }

    @Override
    public Student studentDetailsDtoToStudent(StudentDetailsDTO student) {
        if ( student == null ) {
            return null;
        }

        Student student1 = new Student();

        student1.setFirstName( student.getFirstName() );
        student1.setLastName( student.getLastName() );

        return student1;
    }

    protected CourseDTO courseToCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setDescription( course.getDescription() );

        return courseDTO;
    }

    protected Set<CourseDTO> courseSetToCourseDTOSet(Set<Course> set) {
        if ( set == null ) {
            return null;
        }

        Set<CourseDTO> set1 = new LinkedHashSet<CourseDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Course course : set ) {
            set1.add( courseToCourseDTO( course ) );
        }

        return set1;
    }

    protected Course courseDTOToCourse(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setDescription( courseDTO.getDescription() );

        return course;
    }

    protected Set<Course> courseDTOSetToCourseSet(Set<CourseDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Course> set1 = new LinkedHashSet<Course>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CourseDTO courseDTO : set ) {
            set1.add( courseDTOToCourse( courseDTO ) );
        }

        return set1;
    }
}
