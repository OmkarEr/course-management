package com.coursemanagement.coursemanagement.course;

import com.coursemanagement.coursemanagement.topic.Topic;
import com.coursemanagement.coursemanagement.topic.TopicService;
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
    public List<Course> getALlTopics() {
        return courseService.getAllCourses();
    }

    //Gets course with the provided topic and course id
    @GetMapping(value="/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getTopicById(@PathVariable String topicId, @PathVariable String courseId){
        return courseService.getCourseById(topicId, courseId);
    }

    //Adds a course to the given topic
    @RequestMapping(value="/topics/{topicId}/addcourse", method=RequestMethod.POST)
    public void addTopic(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    //Updates the course
    @RequestMapping(value="/topics/{topicId}/update", method=RequestMethod.PUT)
    public void updateTopic(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    //Deletes a course
    @RequestMapping(value="/topics/{topicId}/courses/delete/{courseId}/", method=RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
