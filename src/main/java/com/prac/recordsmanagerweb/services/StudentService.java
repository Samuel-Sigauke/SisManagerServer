package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.StudentDto;
import com.prac.recordsmanagerweb.entities.Student;
import com.prac.recordsmanagerweb.models.StudentListResponse;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<Student> createStudent(StudentDto studentDto);
    StudentListResponse findAllStudents(int page);
    Student findStudent(String studentNumber);
    Student deleteStudent(String studentNumber);

}
