package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.TeacherDto;
import com.prac.recordsmanagerweb.entities.Teacher;
import com.prac.recordsmanagerweb.exceptions.NotFoundException;
import com.prac.recordsmanagerweb.models.TeacherListResponse;
import com.prac.recordsmanagerweb.repositories.TeacherRepository;
import com.prac.recordsmanagerweb.services.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherServiceimpl  implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public ResponseEntity<Teacher> createTeacher(TeacherDto teacherDto) {

        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setRegnumber(teacherDto.getRegnumber());
        teacher.setNationalid(teacherDto.getNationalid());
        teacher.setClasstag(teacherDto.getClasstag());

        Teacher savedTeacher = teacherRepository.save(teacher);

        String SuccessMsg = "Teaher Successfully created";
        String FailMsg = "An error occured whilst saving new Teacher";
        Message message = new Message();

        if (savedTeacher !=null) {
            message.setMessage(SuccessMsg);
            log.info(SuccessMsg);
            return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
        }else {
            message.setMessage(FailMsg);
            log.info(FailMsg);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public TeacherListResponse findAllTeachers(int page) {

        Pageable pageWithTen = PageRequest.of(page, 10);
        Page<Teacher> optionalTeachers = teacherRepository.findAll(pageWithTen);
        List<Teacher> teacherList = optionalTeachers.getContent();

        TeacherListResponse teacherListResponse = new TeacherListResponse();
        teacherListResponse.setCount(teacherList.size());
        teacherListResponse.setTeachers(teacherList);
        log.info(" {}", teacherList);
        return teacherListResponse;

    }

    @Override
    public Teacher findTeacher(String regNumber) {

        Teacher teacher = teacherRepository.findByRegnumber(regNumber).orElse(null);
        if (teacher == null) {
            throw new NotFoundException("Student with "+regNumber+ " does not exist");
        }else {
            log.info(" {} ", teacher);
            return teacher;
        }
    }

    @Override
    public Teacher deleteTeacher(String regNumber) {

        Teacher teacher = teacherRepository.findByRegnumber(regNumber).orElse(null);
        if (teacher == null) {
            throw new NotFoundException("Student with "+regNumber+ " does not exist");
        }else {
            teacherRepository.delete(teacher);
            log.info("Deleted {} ", teacher);
            return teacher;
        }
    }
}
