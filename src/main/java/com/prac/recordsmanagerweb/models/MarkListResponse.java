package com.prac.recordsmanagerweb.models;

import com.prac.recordsmanagerweb.entities.Mark;

import java.util.List;

public class MarkListResponse {

    private  int count;
    private List<Mark> marks;
    public void setCount(int size) { }
    public void setMarks(List<Mark> markList) { }
}
