package com.acum.homeassignment.repository;

import com.acum.homeassignment.model.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
