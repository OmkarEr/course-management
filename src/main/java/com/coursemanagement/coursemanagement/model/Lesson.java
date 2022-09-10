package com.coursemanagement.coursemanagement.model;

import com.coursemanagement.coursemanagement.model.Course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lesson {

    @Id
    private String lessonId;
    private String lessonName;
    private String lessonDescription;

    @ManyToOne
    private Course course;

    public Lesson() {

    }

    public Lesson(String lessonId, String lessonName, String lessonDescription, String courseId) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
        this.course = new Course(courseId, null, null, null);
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
