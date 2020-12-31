package com.prac.recordsmanagerweb.controllers;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.SubjectDto;
import com.prac.recordsmanagerweb.entities.Subject;
import com.prac.recordsmanagerweb.models.SubjectListResponse;
import com.prac.recordsmanagerweb.services.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<Message> create(@RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @GetMapping("/find/all/{page}")
    public SubjectListResponse findAll(@PathVariable("page")int page) {
        return  subjectService.findAllSubjects(page);
    }

    @GetMapping("/find/code/{subjectCode}")
    public Subject findSubject(@PathVariable String subjectCode) { return subjectService.findSubject(subjectCode); }

    @GetMapping("/find/name/{subjectName}")
    public Subject findSubjectByName(@PathVariable String subjectName) { return subjectService.findSubjectByName(subjectName); }
}

