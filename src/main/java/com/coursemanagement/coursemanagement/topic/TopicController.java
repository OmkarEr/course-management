package com.coursemanagement.coursemanagement.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    //Gets a list of all the topics
    @GetMapping(value="/topics")
    public List<Topic> getALlTopics() {
        return topicService.getAllTopics();
    }

    //Gets topic with the provided topic id
    @GetMapping(value="/topics/{topicId}")
    public Optional<Topic> getTopicById(@PathVariable String topicId){
        return topicService.getTopicById(topicId);
    }

    //Adds a topic
    @RequestMapping(value="/topics/addtopic", method=RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //Updates the topic
    @RequestMapping(value="/topics/update", method=RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    //Deletes a topic
    @RequestMapping(value="/topics/delete/{topicId}", method=RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String topicId){
        topicService.deleteTopic(topicId);
    }
}
