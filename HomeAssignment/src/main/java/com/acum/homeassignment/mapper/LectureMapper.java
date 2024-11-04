package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.LectureDTO;
import com.acum.homeassignment.model.entity.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LectureMapper {

    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);

    LectureDTO lectureToLectureDTO(Lecture lecture);

    Lecture lectureDTOToLecture(LectureDTO lectureDTO);
}
