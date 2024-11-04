package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.LectureDTO;
import com.acum.homeassignment.model.entity.Lecture;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-04T20:20:18+0200",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class LectureMapperImpl implements LectureMapper {

    @Override
    public LectureDTO lectureToLectureDTO(Lecture lecture) {
        if ( lecture == null ) {
            return null;
        }

        LectureDTO lectureDTO = new LectureDTO();

        lectureDTO.setLecturer( lecture.getLecturer() );
        lectureDTO.setFieldOfStudy( lecture.getFieldOfStudy() );

        return lectureDTO;
    }

    @Override
    public Lecture lectureDTOToLecture(LectureDTO lectureDTO) {
        if ( lectureDTO == null ) {
            return null;
        }

        Lecture lecture = new Lecture();

        lecture.setLecturer( lectureDTO.getLecturer() );
        lecture.setFieldOfStudy( lectureDTO.getFieldOfStudy() );

        return lecture;
    }
}
