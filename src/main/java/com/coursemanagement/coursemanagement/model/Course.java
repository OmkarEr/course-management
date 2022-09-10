package com.coursemanagement.coursemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    private String id;
    private String courseName;
    private String courseDescription;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String courseId, String courseName, String courseDescription, String topicId) {
        this.id = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.topic = new Topic(topicId, "", "");
    }

    public String getCourseId() {
        return id;
    }

    public void setCourseId(String courseId) {
        this.id = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
