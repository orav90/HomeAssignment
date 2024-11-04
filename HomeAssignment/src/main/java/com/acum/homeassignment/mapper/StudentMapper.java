package com.acum.homeassignment.mapper;

import com.acum.homeassignment.model.dto.StudentDTO;
import com.acum.homeassignment.model.dto.StudentDetailsDTO;
import com.acum.homeassignment.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentToStudentDTO(Student student);

    Student studentDTOToStudent(StudentDTO studentDTO);

    StudentDetailsDTO studentToStudentDetailsDTO(Student student);

    Student studentDetailsDtoToStudent(StudentDetailsDTO student);
}

