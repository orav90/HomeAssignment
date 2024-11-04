package com.acum.homeassignment.service;

import com.acum.homeassignment.mapper.LectureMapper;
import com.acum.homeassignment.model.dto.LectureDTO;
import com.acum.homeassignment.model.entity.Lecture;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

    public LectureDTO lectureToDTO(Lecture lecture) {
        return LectureMapper.INSTANCE.lectureToLectureDTO(lecture);
    }

    public Lecture dtoToLecture(LectureDTO lectureDTO) {
        return LectureMapper.INSTANCE.lectureDTOToLecture(lectureDTO);
    }
}


