package com.prac.recordsmanagerweb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "mark", schema = "public")
@Data
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column
    private String studentnumber;
    @Column
    private String markname;
    @Column
    private int mark;
    @Column
    private String subjectcode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentnumber", nullable = false)
    @JsonBackReference
    @Transient
    private Student student;

}
