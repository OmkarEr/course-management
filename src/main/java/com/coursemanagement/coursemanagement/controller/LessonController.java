package com.coursemanagement.coursemanagement.controller;

import com.coursemanagement.coursemanagement.service.LessonService;
import com.coursemanagement.coursemanagement.model.Course;
import com.coursemanagement.coursemanagement.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    //Gets a list of all the lessons for a given course
    @GetMapping(value="/topics/courses/{courseId}/lessons")
    public List<Lesson> getALlLessons(@PathVariable String courseId) {
        return lessonService.getAllLessons(courseId);
    }

    //Gets course with the provided topic and course id
    @GetMapping(value="/topics/courses/lessons/{lessonId}")
    public Optional<Lesson> getLessonById(@PathVariable String courseId, @PathVariable String lessonId){
        return lessonService.getLessonById(lessonId);
    }

    //Adds a course to the given topic
    @RequestMapping(value="/topics/courses/{courseId}/lessons/addlesson", method=RequestMethod.POST)
    public void addLesson(@PathVariable String courseId, @RequestBody Lesson lesson){
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.addLesson(lesson);
    }

    //Updates the course
    @RequestMapping(value="/topics/Courses/{courseId}/lessons/update", method=RequestMethod.PUT)
    public void updateLesson(@PathVariable String courseId, @RequestBody Lesson lesson){
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.updateLesson(lesson);
    }

    //Deletes a course
    @RequestMapping(value="/topics/courses/lessons/delete/{lessonId}", method=RequestMethod.DELETE)
    public void deleteLesson(@PathVariable String lessonId){
        lessonService.deleteLesson(lessonId);
    }
}
