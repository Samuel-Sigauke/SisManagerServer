package com.prac.recordsmanagerweb.controllers;


import com.prac.recordsmanagerweb.dto.StudentDto;
import com.prac.recordsmanagerweb.entities.Student;
import com.prac.recordsmanagerweb.models.StudentListResponse;
import com.prac.recordsmanagerweb.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
    @GetMapping("/students/all/{page}")
    public StudentListResponse findAllStudents (@PathVariable("page") int page) {
        return studentService.findAllStudents(page);
    }

    @GetMapping("/students/{studentNumber}")
    public Student findStudentByStudentNumber (@PathVariable String studentNumber ) { return studentService.findStudent(studentNumber); }

    @DeleteMapping("/delete/{studentNumber}")
    public Student deleteStudent(@PathVariable String studentNumber) { return  studentService.deleteStudent(studentNumber); }

}
