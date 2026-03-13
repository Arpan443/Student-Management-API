package com.example.restapi_create.Services.Implementations;

import com.example.restapi_create.Services.StudentService;
import com.example.restapi_create.dto.AddStudentRequestDto;
import com.example.restapi_create.dto.StudentDto;
import com.example.restapi_create.entity.Student;
import com.example.restapi_create.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {

    private  final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRepo.findAll();
        return students.stream().map(students1 -> modelMapper.map(students1, StudentDto.class)).toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
       Student student= studentRepo.findById(id).orElseThrow( ()-> new IllegalArgumentException("Student not found  with id"+id));
       return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent= modelMapper.map(addStudentRequestDto, Student.class);
        Student student= studentRepo.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepo.existsById(id)){
           throw new IllegalArgumentException("Student does not exist in database by id"+id);
        }
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto) {
        Student student= studentRepo.findById(id).orElseThrow( ()-> new IllegalArgumentException("Student not found  with id"+id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepo.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(long id, Map<String, Object> updates) {
        Student student= studentRepo.findById(id).orElseThrow( ()-> new IllegalArgumentException("Student not found  with id"+id));
       updates.forEach((field , value) ->{
     switch (field) {
         case "name":
             student.setName((String) value);
             break;
         case "email":
             student.setEmail((String) value);
             break;
         default:
             throw new IllegalArgumentException("Field is not supported ");
     }
       });
       Student savedStudent= studentRepo.save(student);
       return modelMapper.map(savedStudent, StudentDto.class);


    }
}


