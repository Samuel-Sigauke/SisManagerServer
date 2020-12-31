package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.Mark;
import com.prac.recordsmanagerweb.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

    @Override
    Page<Mark> findAllByStudentnumber(Pageable pageable);
    Page<Mark> findAllByStudentnumberAndClassCode(Pageable pageable);

    Optional<Subject> findBySubjectCode(String subjectCode);

    Optional<Subject> findBySubjectName(String subjectName);

    List<Mark> findAllByStudentnumber(String studentnumber);
}
