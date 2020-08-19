package com.example.newWeb.repository;

import com.example.newWeb.models.Course;
import com.example.newWeb.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course>  findByTopicId(String topicId);


}
