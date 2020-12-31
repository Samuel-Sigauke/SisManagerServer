package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.ClassDto;
import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.entities.Grade;
import com.prac.recordsmanagerweb.models.GradeListResponse;
import org.springframework.http.ResponseEntity;

public interface GradeService {

    ResponseEntity<Message> createGrade(ClassDto classDto);
    GradeListResponse findAllGrades(int page);
    Grade findGrade(String classCode);
    Grade deleteGrade(String classCode);
}
