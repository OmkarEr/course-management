package com.coursemanagement.coursemanagement.model;

import javax.persistence.*;

@Entity
public class Topic {
    @Id
    private String id;
    private String topicName;
    private String topicDescription;

    public Topic() {
    }

    public Topic(String topicId, String topicName, String topicDescription) {
        this.id = topicId;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
    }

    public String getTopicId() {
        return id;
    }

    public void setTopicId(String topicId) {
        this.id = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }
}
