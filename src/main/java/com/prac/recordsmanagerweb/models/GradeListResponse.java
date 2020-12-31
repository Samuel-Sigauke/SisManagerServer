package com.prac.recordsmanagerweb.models;

import com.prac.recordsmanagerweb.entities.Grade;
import lombok.Data;

import java.util.List;

@Data
public class GradeListResponse {

    private  int count;
    private List<Grade> grades;
    public void setCount(int size) { }
    public void setGrades(List<Grade> gradeList) { }
}
