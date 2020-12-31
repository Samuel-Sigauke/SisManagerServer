package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.dto.ClassDto;
import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.entities.Grade;
import com.prac.recordsmanagerweb.exceptions.NotFoundException;
import com.prac.recordsmanagerweb.models.GradeListResponse;
import com.prac.recordsmanagerweb.repositories.GradeRepository;
import com.prac.recordsmanagerweb.services.GradeService;
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
public class GradeServiceimpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public ResponseEntity<Message> createGrade(ClassDto classDto) {

        Grade grade = new Grade();
        //grade.setId(classDto.getId());
        grade.setClasscode(classDto.getClasscode());
        grade.setClassname(classDto.getClassname());
        grade.setClasstag(classDto.getClasstag());

        Grade savedGrade = gradeRepository.save(grade);
        String SuccessMsg = classDto.getClassname()+ " Class Saved Successfully";
        String FailMsg = "An error occured whilst saving your Class";
        Message message = new Message();

        if(savedGrade !=null){
            message.setMessage(SuccessMsg);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.setMessage(FailMsg);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public GradeListResponse findAllGrades(int page) {
        Pageable pageWithTenElements = PageRequest.of(page, 10);
        Page<Grade> optionalGrades = gradeRepository.findAll(pageWithTenElements);
        List<Grade> gradeList = optionalGrades.getContent();

        GradeListResponse gradeListResponse = new GradeListResponse();
        gradeListResponse.setCount(gradeList.size());
        gradeListResponse.setGrades(gradeList);
        log.info("List {} ", gradeList);
        return gradeListResponse;
    }

    public Grade findGrade(String classTag){
        Grade grade = gradeRepository.findByClasstag(classTag).orElse(null);
        if(grade == null){
            throw new NotFoundException("Class with class code "+classTag+" does not exist");
        }
        return grade;
    }

    public Grade deleteGrade(String classTag){
        Grade grade = gradeRepository.findByClasstag(classTag).orElse(null);
        if(grade == null){
            throw new NotFoundException("Class with class code "+classTag+" does not exist");
        }else {
            gradeRepository.delete(grade);
            return grade;
        }
    }
}
