package com.coursemanagement.coursemanagement.controller;

import com.coursemanagement.coursemanagement.service.CourseService;
import com.coursemanagement.coursemanagement.model.Course;
import com.coursemanagement.coursemanagement.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Gets a list of all the courses for a given topic
    @GetMapping(value="/topics/{topicId}/courses")
    public List<Course> getALlCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    //Gets course with the provided topic and course id
    @GetMapping(value="/topics/courses/{courseId}")
    public Optional<Course> getCourseById(@PathVariable String topicId, @PathVariable String courseId){
        return courseService.getCourseById(courseId);
    }

    //Adds a course to the given topic
    @RequestMapping(value="/topics/{topicId}/courses/addcourse", method=RequestMethod.POST)
    public void addCourse(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    //Updates the course
    @RequestMapping(value="/topics/{topicId}/courses/update", method=RequestMethod.PUT)
    public void updateCourse(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    //Deletes a course
    @RequestMapping(value="/topics/courses/delete/{courseId}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
