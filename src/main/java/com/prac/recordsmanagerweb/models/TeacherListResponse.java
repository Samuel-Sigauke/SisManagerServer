package com.prac.recordsmanagerweb.models;

import com.prac.recordsmanagerweb.entities.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class TeacherListResponse {

    private int count;
    private List<Teacher> teachers;
}
