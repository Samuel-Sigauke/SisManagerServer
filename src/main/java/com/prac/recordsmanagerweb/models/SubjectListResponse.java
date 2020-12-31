package com.prac.recordsmanagerweb.models;


import com.prac.recordsmanagerweb.entities.Subject;
import lombok.Data;

import java.util.List;

@Data
public class SubjectListResponse {

    private int count;
    private List<Subject> subjects;
    /** public void setCount(int size) { }
    public void setSubjects(List<Subject> subjectList) { } */
}
