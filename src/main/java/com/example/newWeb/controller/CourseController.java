package com.example.newWeb.controller;

import com.example.newWeb.models.Course;
import com.example.newWeb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("topic/{id}/courses")
    public List<Course> getAllCourses(@PathVariable  String topicId){
        return courseService.getAllCourses(topicId);
    }
    @RequestMapping("topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable  String id){
        return courseService.getCourse(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "topic/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String id){
        courseService.addCourse(course);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "topic/{id}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(id, course);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "topic/{id}/courses/{id}")
    public void deleteCourse(@PathVariable  String id){
        courseService.deleteCourse(id);
    }
}
