package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.TeacherDto;
import com.prac.recordsmanagerweb.entities.Teacher;
import com.prac.recordsmanagerweb.models.TeacherListResponse;
import org.springframework.http.ResponseEntity;

public interface TeacherService {

    ResponseEntity<Teacher> createTeacher(TeacherDto teacherDto);
    TeacherListResponse findAllTeachers(int page);
    Teacher findTeacher(String regNumber);
    Teacher deleteTeacher(String regNumber);
}
