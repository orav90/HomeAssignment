package com.acum.homeassignment.model.dto;

import lombok.Data;
import java.util.Set;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private Set<CourseDTO> courses;

}
