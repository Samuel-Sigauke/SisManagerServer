package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Override
    Page<Grade> findAll(Pageable pageable);

    Optional<Grade> findByClasstag(String classTag);
}
