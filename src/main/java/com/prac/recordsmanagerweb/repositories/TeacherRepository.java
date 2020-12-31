package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Page<Teacher> findAll(Pageable pageable);

    Optional<Teacher> findByRegnumber(String regNumber);
}
