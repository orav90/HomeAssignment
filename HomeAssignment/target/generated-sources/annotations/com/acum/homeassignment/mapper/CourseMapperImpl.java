package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.CourseDTO;
import com.acum.homeassignment.model.entity.Course;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-04T20:20:18+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO courseToCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setDescription( course.getDescription() );

        return courseDTO;
    }

    @Override
    public Course courseDTOToCourse(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setDescription( courseDTO.getDescription() );

        return course;
    }
}
