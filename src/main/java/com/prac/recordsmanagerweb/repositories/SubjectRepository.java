package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

    @Override
    Page<Subject> findAll(Pageable pageable);

    Optional<Subject> findBySubjectCode(String subjectCode);

    Optional<Subject> findBySubjectName(String subjectName);
}
