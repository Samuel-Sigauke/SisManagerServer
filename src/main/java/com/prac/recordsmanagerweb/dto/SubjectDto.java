package com.prac.recordsmanagerweb.dto;

import lombok.Data;

import java.sql.Blob;

@Data
public class SubjectDto {

    private long id;
    private String subjectName;
    private String subjectCode;
    private String subjectDescription;
    private Blob subjectSyllabus;
    private String classCode;
}
