package com.example.restapi_create.Services;

import com.example.restapi_create.dto.AddStudentRequestDto;
import com.example.restapi_create.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(long id, Map<String, Object> updates);
}
