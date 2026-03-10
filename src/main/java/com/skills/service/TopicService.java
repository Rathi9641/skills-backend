package com.skills.service;

import com.skills.model.Topic;
import com.skills.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository repo;

    public TopicService(TopicRepository repo) {
        this.repo = repo;
    }

    public List<Topic> getAllTopics() {
        return repo.findAll();
    }

    public Topic addTopic(Topic topic) {
        return repo.save(topic);
    }

    public Topic updateTopic(Long id, Topic topic) {
        topic.setId(id);
        return repo.save(topic);
    }

    public void deleteTopic(Long id) {
        repo.deleteById(id);
    }
}
