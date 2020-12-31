package com.prac.recordsmanagerweb.controllers;

import com.prac.recordsmanagerweb.dto.TeacherDto;
import com.prac.recordsmanagerweb.entities.Teacher;
import com.prac.recordsmanagerweb.models.TeacherListResponse;
import com.prac.recordsmanagerweb.services.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherDto teacherDto) { return  teacherService.createTeacher(teacherDto); }

    @GetMapping("/find/all/{page}")
    public TeacherListResponse findAllTeachers(@PathVariable("page") int page) { return  teacherService.findAllTeachers(page); }

    @GetMapping("/find/{regNumber}")
    public Teacher findTeacherByRegNumber(@PathVariable String regNumber) { return  teacherService.findTeacher(regNumber); }

    @DeleteMapping("delete/{regNumber}")
    public Teacher deleteTeacher(@PathVariable String regNumber) { return teacherService.deleteTeacher(regNumber); }
}
