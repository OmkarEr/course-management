package com.coursemanagement.coursemanagement.service;

import com.coursemanagement.coursemanagement.model.Lesson;
import com.coursemanagement.coursemanagement.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId).forEach(lessons::add);
        return lessons;
    }

    public Optional<Lesson> getLessonById(String lessonId) {
        return lessonRepository.findById(lessonId);
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
