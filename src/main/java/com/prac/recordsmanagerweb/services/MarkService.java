package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.MarkDto;
import com.prac.recordsmanagerweb.entities.Mark;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MarkService {

    ResponseEntity<Mark> saveMark(MarkDto markDto);
    List<Mark> findByStudentNumber(String studentnumber);
}
