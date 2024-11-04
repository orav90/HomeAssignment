package com.acum.homeassignment.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Setter
public class Student extends BaseEntity{

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "enrollment",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id") )
    private Set<Course> courses = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
