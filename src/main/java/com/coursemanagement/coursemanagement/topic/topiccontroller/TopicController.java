package com.coursemanagement.coursemanagement.topic.topiccontroller;

import com.coursemanagement.coursemanagement.topic.Topic;
import com.coursemanagement.coursemanagement.topic.topicservice.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value="/topics")
    public List<Topic> getALlTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping(value="/topics/{topicId}")
    public Optional<Topic> getTopicById(@PathVariable String topicId){
        return topicService.getTopicById(topicId);
    }

    @RequestMapping(value="/addtopic", method=RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    @RequestMapping(value="/delete/{topicId}", method=RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String topicId){
        topicService.deleteTopic(topicId);
    }
}
