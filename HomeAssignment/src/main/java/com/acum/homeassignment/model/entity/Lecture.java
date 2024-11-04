package com.acum.homeassignment.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Lecture extends BaseEntity {

    private String lecturer;
    private String fieldOfStudy;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
