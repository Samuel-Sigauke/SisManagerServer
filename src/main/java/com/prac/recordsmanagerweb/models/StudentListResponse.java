package com.prac.recordsmanagerweb.models;


import com.prac.recordsmanagerweb.entities.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentListResponse {

    private int count;
    private List<Student> students;
    //public void setCount(int size) { }
    //public void setStudents(List<Student> studentList) { }
}
