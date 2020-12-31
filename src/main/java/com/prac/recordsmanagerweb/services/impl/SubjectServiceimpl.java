package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.SubjectDto;
import com.prac.recordsmanagerweb.entities.Subject;
import com.prac.recordsmanagerweb.exceptions.NotFoundException;
import com.prac.recordsmanagerweb.models.SubjectListResponse;
import com.prac.recordsmanagerweb.repositories.SubjectRepository;
import com.prac.recordsmanagerweb.services.SubjectService;
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
public class SubjectServiceimpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<Message> createSubject(SubjectDto subjectDto) {

        Subject subject = new Subject();
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setSubjectCode(subjectDto.getSubjectCode());
        subject.setSubjectDescription(subjectDto.getSubjectDescription());
        subject.setSubjectSyllabus(subjectDto.getSubjectSyllabus());
        subject.setClassCode(subjectDto.getClassCode());

        Subject savedSubject = subjectRepository.save(subject);
        String SuccessMsg = subjectDto.getSubjectName()+ " Subject Saved Successfully";
        String FailMsg = "An error occured whilst saving your Subject";
        Message message = new Message();

        if (savedSubject !=null){
            message.setMessage(SuccessMsg);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.setMessage(FailMsg);
            return  new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public SubjectListResponse findAllSubjects(int page) {
        Pageable pageWithTenElements = PageRequest.of(page, 10);
        Page<Subject> optionalSubjects = subjectRepository.findAll(pageWithTenElements);
        List<Subject> subjectList = optionalSubjects.getContent();

        SubjectListResponse subjectListResponse = new SubjectListResponse();
        subjectListResponse.setCount(subjectList.size());
        subjectListResponse.setSubjects(subjectList);
        log.info("List {} ", subjectList);
        return subjectListResponse;
    }

    public Subject findSubject(String subjectCode){
        Subject subject = subjectRepository.findBySubjectCode(subjectCode).orElse(null);
        if(subject == null){
            throw new NotFoundException("Class with class code "+subjectCode+" does not exist");
        }
        return subject;
    }

    public Subject findSubjectByName(String subjectName){
        Subject subject = subjectRepository.findBySubjectName(subjectName).orElse(null);
        if(subject == null){
            throw new NotFoundException("Class with class code "+subjectName+" does not exist");
        }
        return subject;
    }
}
