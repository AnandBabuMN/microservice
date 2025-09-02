package com.enrollment.repository;

import com.enrollment.entity.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Long> {
    @Query(value = "select * from enrollment where student_id = ?1 and course_id = ?2 and is_revert IS FALSE", nativeQuery = true)
    Optional<EnrollEntity> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Query(value = "select * from enrollment where student_id = ? and is_revert IS FALSE", nativeQuery = true)
    List<EnrollEntity> findByStudentId(Long id);
}
