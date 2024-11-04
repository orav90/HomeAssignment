package com.acum.homeassignment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseWithStudentsDTO {
    private String description;
    private Long studentCount;
}
