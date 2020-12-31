package com.prac.recordsmanagerweb.controllers;


import com.prac.recordsmanagerweb.dto.ClassDto;
import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.entities.Grade;
import com.prac.recordsmanagerweb.models.GradeListResponse;
import com.prac.recordsmanagerweb.services.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("class")
public class GradeController {

    @Autowired
    private GradeService gradeSevice;

    @PostMapping("/create")
    public ResponseEntity<Message> createGrade(@RequestBody ClassDto classDto) {
        return gradeSevice.createGrade(classDto);
    }

    @GetMapping("/grades/all/{page}")
    public GradeListResponse findall(@PathVariable("page")int page) {
        return  gradeSevice.findAllGrades(page);
    }

    @GetMapping("/grades/{classTag}")
    public Grade getGradeByCode(@PathVariable String classTag) { return gradeSevice.findGrade(classTag); }

    @DeleteMapping("/delete/{classTag}")
    public Grade deleteGrade(@PathVariable String classTag) { return gradeSevice.deleteGrade(classTag); }
}
