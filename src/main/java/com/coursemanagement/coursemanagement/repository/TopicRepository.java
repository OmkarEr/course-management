package com.coursemanagement.coursemanagement.repository;

import com.coursemanagement.coursemanagement.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
