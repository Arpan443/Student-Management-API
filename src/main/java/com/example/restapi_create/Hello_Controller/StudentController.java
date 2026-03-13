package com.example.restapi_create.Hello_Controller;

import com.example.restapi_create.Services.StudentService;
import com.example.restapi_create.dto.AddStudentRequestDto;
import com.example.restapi_create.dto.StudentDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")

@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;



    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent() {
  //      return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity< StudentDto > getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));



    }
    @PostMapping("")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
       return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public  ResponseEntity<StudentDto> updateStudent(@PathVariable long id,@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id , addStudentRequestDto));
    }
    @PatchMapping("{id}")
    public  ResponseEntity<StudentDto> updatePartialStudent(@PathVariable long id, @RequestBody Map<String ,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id , updates));
    }

}
