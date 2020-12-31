package com.prac.recordsmanagerweb.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "subject", schema = "public")
@Data
public class Subject {

    @Id
    private long id;

    @Column
    private String subjectName;
    @Column
    private String subjectCode;
    @Column
    private String subjectDescription;
    @Column
    private Blob subjectSyllabus;
    @Column
    private String classTag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classTag", nullable = false)
    @JsonBackReference
    @Transient
    private Grade grade;


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getSubjectName() { return subjectName; }

    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public String getSubjectCode() { return subjectCode; }

    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public String getSubjectDescription() { return subjectDescription; }

    public void setSubjectDescription(String subjectDescription) { this.subjectDescription = subjectDescription; }

    public Blob getSubjectSyllabus() { return subjectSyllabus; }

    public void setSubjectSyllabus(Blob subjectSyllabus) { this.subjectSyllabus = subjectSyllabus; }

    public String getClassCode() { return classTag; }

    public void setClassCode(String classCode) { this.classTag = classCode; }
}
