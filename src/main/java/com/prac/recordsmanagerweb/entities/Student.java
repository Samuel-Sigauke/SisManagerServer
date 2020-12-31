package com.prac.recordsmanagerweb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student", schema = "public")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String name;
    @Column
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateofbirth;
    @Column
    private String studentnumber;
    @Column
    private String classtag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classtag", nullable = false)
    @JsonBackReference
    @Transient
    private Grade grade;

    @OneToMany(mappedBy = "studentnumber", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JsonManagedReference
    @Transient
    private List<Mark> markList;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public LocalDate getDateOfBirth() { return dateofbirth; }

    public void setDateOfBirth(LocalDate dateofbirth) { this.dateofbirth = dateofbirth; }

    public String getStudentnumber() { return studentnumber; }

    public void setStudentnumber(String studentnumber) { this.studentnumber = studentnumber; }

    public String getClasstag() { return classtag; }

    public void setClasstag(String classtag) { this.classtag = classtag; }

    public Grade getGrade() { return grade; }

    public void setGrade(Grade grade) { this.grade = grade; }
}
