package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.CourseDTO;
import com.acum.homeassignment.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO courseToCourseDTO(Course course);

    Course courseDTOToCourse(CourseDTO courseDTO);
}
