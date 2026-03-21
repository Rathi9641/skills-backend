package com.skills.service;

import com.skills.dto.TopicDTO;
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

    // ✅ GET ALL
    public List<TopicDTO> getAllTopics() {

        List<Topic> topics = repo.findAll();

        return topics.stream().map(t -> {
            TopicDTO dto = new TopicDTO();
            dto.setName(t.getName());
            dto.setDescription(t.getDescription());
            return dto;
        }).toList();
    }

    // ✅ ADD
    public TopicDTO addTopic(TopicDTO dto) {

        Topic topic = new Topic();
        topic.setName(dto.getName());
        topic.setDescription(dto.getDescription());

        Topic saved = repo.save(topic);

        TopicDTO result = new TopicDTO();
        result.setName(saved.getName());
        result.setDescription(saved.getDescription());

        return result;
    }

    // ✅ UPDATE
    public TopicDTO updateTopic(Long id, TopicDTO dto) {

        Topic topic = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        topic.setName(dto.getName());
        topic.setDescription(dto.getDescription());

        Topic updated = repo.save(topic);

        TopicDTO result = new TopicDTO();
        result.setName(updated.getName());
        result.setDescription(updated.getDescription());

        return result;
    }

    // ✅ DELETE
    public void deleteTopic(Long id) {
        repo.deleteById(id);
    }
}