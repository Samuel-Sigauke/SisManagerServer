package com.prac.recordsmanagerweb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher", schema = "public")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String regnumber;
    @Column
    private String nationalid;
    @Column
    private String classtag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classtag", nullable = false)
    @JsonBackReference
    @Transient
    private Grade grade;
}
