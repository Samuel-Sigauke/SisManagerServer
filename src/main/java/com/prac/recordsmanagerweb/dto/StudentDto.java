package com.prac.recordsmanagerweb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private String name;
    private String surname;
    private LocalDate dateofbirth;
    private String studentnumber;
    private String classtag;
}
