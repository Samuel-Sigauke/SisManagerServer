package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findAll(Pageable pageable);

    Optional<Student> findByStudentnumber(String studentNumber);
}
