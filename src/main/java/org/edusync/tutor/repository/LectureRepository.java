package org.edusync.tutor.repository;

import org.edusync.tutor.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    // 기본적인 CRUD 메서드는 JpaRepository가 제공
    // 필요한 추가 쿼리 메서드는 여기에 선언
} 