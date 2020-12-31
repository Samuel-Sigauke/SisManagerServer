package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.SubjectDto;
import com.prac.recordsmanagerweb.entities.Subject;
import com.prac.recordsmanagerweb.models.SubjectListResponse;
import org.springframework.http.ResponseEntity;

public interface SubjectService {

    ResponseEntity<Message> createSubject(SubjectDto subjectDto);
    SubjectListResponse findAllSubjects(int page);
    Subject findSubject(String subjectCode);
    Subject findSubjectByName(String subjectName);
}
