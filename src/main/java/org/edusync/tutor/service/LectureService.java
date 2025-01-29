package org.edusync.tutor.service;

import org.edusync.tutor.dto.LectureRequest;
import org.edusync.tutor.entity.Lecture;
import org.edusync.tutor.exception.LectureNotFoundException;
import org.edusync.tutor.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LectureService {
    
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public Lecture createLecture(LectureRequest request) {
        Lecture lecture = new Lecture();
        updateLectureFromRequest(lecture, request);
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture getLecture(Long id) {
        return lectureRepository.findById(id)
            .orElseThrow(() -> new LectureNotFoundException(id));
    }

    @Transactional
    public Lecture updateLecture(Long id, LectureRequest request) {
        Lecture lecture = getLecture(id);
        updateLectureFromRequest(lecture, request);
        return lectureRepository.save(lecture);
    }

    @Transactional
    public void deleteLecture(Long id) {
        if (!lectureRepository.existsById(id)) {
            throw new LectureNotFoundException(id);
        }
        lectureRepository.deleteById(id);
    }

    private void updateLectureFromRequest(Lecture lecture, LectureRequest request) {
        lecture.setStudentId(request.getStudentId());
        lecture.setSubject(request.getSubject());
        lecture.setLessonDay(request.getLessonDay());
        lecture.setLessonStartTime(LocalTime.parse(request.getLessonStartTime()));
        lecture.setLessonEndTime(LocalTime.parse(request.getLessonEndTime()));
        lecture.setTuition(request.getTuition());
        lecture.setTuitionCycle(request.getTuitionCycle());
    }
} 