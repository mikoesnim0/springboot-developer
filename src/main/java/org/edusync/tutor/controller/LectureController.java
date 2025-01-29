package org.edusync.tutor.controller;

import org.edusync.tutor.dto.LectureRequest;
import org.edusync.tutor.entity.Lecture;
import org.edusync.tutor.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {
    
    private final LectureService lectureService;
    private static final Logger log = LoggerFactory.getLogger(LectureController.class);

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody LectureRequest request) {
        log.info("Creating new lecture for student: {}", request.getStudentId());
        Lecture lecture = lectureService.createLecture(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(lecture);
    }

    @GetMapping
    public ResponseEntity<List<Lecture>> getAllLectures() {
        List<Lecture> lectures = lectureService.getAllLectures();
        return ResponseEntity.ok(lectures);
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<Lecture> getLecture(@PathVariable Long lectureId) {
        Lecture lecture = lectureService.getLecture(lectureId);
        return ResponseEntity.ok(lecture);
    }

    @PutMapping("/{lectureId}")
    public ResponseEntity<Lecture> updateLecture(
            @PathVariable Long lectureId,
            @RequestBody LectureRequest request) {
        log.info("Updating lecture: {}", lectureId);
        Lecture updatedLecture = lectureService.updateLecture(lectureId, request);
        return ResponseEntity.ok(updatedLecture);
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long lectureId) {
        log.info("Deleting lecture: {}", lectureId);
        lectureService.deleteLecture(lectureId);
        return ResponseEntity.noContent().build();
    }
} 