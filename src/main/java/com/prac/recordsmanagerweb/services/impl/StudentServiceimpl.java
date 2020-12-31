package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.StudentDto;
import com.prac.recordsmanagerweb.entities.Student;
import com.prac.recordsmanagerweb.exceptions.NotFoundException;
import com.prac.recordsmanagerweb.models.StudentListResponse;
import com.prac.recordsmanagerweb.repositories.StudentRepository;
import com.prac.recordsmanagerweb.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Student> createStudent(StudentDto studentDto) {

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setDateOfBirth(studentDto.getDateofbirth());
        student.setStudentnumber(studentDto.getStudentnumber());
        student.setClasstag(studentDto.getClasstag());

        Student savedStudent = studentRepository.save(student);

        String SuccessMsg = "Student Successfully created";
        String FailMsg = "An error occured whilst saving your Class";
        Message message = new Message();

        if (savedStudent !=null) {
            message.setMessage(SuccessMsg);
            log.info(SuccessMsg);
            return  new ResponseEntity<>(savedStudent, HttpStatus.OK);
        }else {
            message.setMessage(FailMsg);
            log.info(FailMsg);
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public StudentListResponse findAllStudents(int page) {

        Pageable pageWithTwenty = PageRequest.of(page, 20);
        Page<Student> optionalStudents = studentRepository.findAll(pageWithTwenty);
        List<Student> studentList = optionalStudents.getContent();

        StudentListResponse studentListResponse = new StudentListResponse();
        studentListResponse.setCount(studentList.size());
        studentListResponse.setStudents(studentList);
        log.info("List {} ", studentList);
        return studentListResponse;
    }

    @Override
    public Student findStudent(String studentNumber) {

        Student student = studentRepository.findByStudentnumber(studentNumber).orElse(null);
        if (student == null) {
            throw new NotFoundException("Student with "+studentNumber+ " does not exist");
        }
        log.info("Student {} ", student);
        return student;
    }

    @Override
    public Student deleteStudent(String studentNumber) {

        Student student = studentRepository.findByStudentnumber(studentNumber).orElse(null);
        if (student == null) {
            throw new NotFoundException("Student with "+studentNumber+ " does not exist");
        }else {
            studentRepository.delete(student);
            log.info("Deleted Student with student number"+studentNumber);
            return student;
        }

    }
}
