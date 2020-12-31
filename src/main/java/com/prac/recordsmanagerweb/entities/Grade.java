package com.prac.recordsmanagerweb.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grade", schema = "public" )
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String classcode;
    @Column
    private String classname;
    private String classtag;

    @OneToMany(mappedBy = "grade", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JsonManagedReference
    @Transient
    private List<Subject> subjectList;


    @OneToMany(mappedBy = "grade", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    @Transient
    private List<Teacher> teacherList;


    @OneToMany(mappedBy = "grade", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    @Transient
    private List<Student> studentList;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getClasscode() { return classcode; }

    public void setClasscode(String classcode) { this.classcode = classcode; }

    public String getClassname() { return classname; }

    public void setClassname(String classname) { this.classname = classname; }

    public String getClasstag() { return classtag; }

    public void setClasstag(String classtag) { this.classtag = classtag; }
}
