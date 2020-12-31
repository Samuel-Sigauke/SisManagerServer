package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.dto.MarkDto;
import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.StudentDto;
import com.prac.recordsmanagerweb.entities.Mark;
import com.prac.recordsmanagerweb.entities.Student;
import com.prac.recordsmanagerweb.repositories.MarkRepository;
import com.prac.recordsmanagerweb.repositories.StudentRepository;
import com.prac.recordsmanagerweb.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class MarkServiceimpl implements MarkService {

    @Autowired
    MarkRepository markRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Mark> saveMark(MarkDto markDto) {
        String studentnumber = StudentDto.getStudentnumber();

        Optional<Student> student = studentRepository.findByStudentnumber(studentnumber);

        Mark mark = new Mark();
        mark.setMarkname(markDto.getMarkname());
        mark.setMark(markDto.getMark());
        mark.setSubjectcode(markDto.getSubjectcode());
        mark.setStudentnumber(markDto.getStudentnumber());
        mark.setStudent(student);

        Mark savedMark = markRepository.save(mark);

        String SuccessMsg = "Student Successfully created";
        String FailMsg = "An error occured whilst saving your Class";
        Message message = new Message();

        if (savedMark !=null) {
            message.setMessage(SuccessMsg);
            log.info(SuccessMsg);
            return  new ResponseEntity<>(savedMarkw3 , HttpStatus.OK);
        }else {
            message.setMessage(FailMsg);
            log.info(FailMsg);
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
