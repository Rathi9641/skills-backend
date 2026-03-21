package com.skills.controller;

import com.skills.dto.TopicDTO;
import com.skills.model.Topic;
import com.skills.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return service.getAllTopics();
    }

    @PostMapping("/add")
    public Topic addTopic(@RequestBody TopicDTO dto) {
        return service.addTopic(dto);  // ✅ correct
    }


    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        return service.updateTopic(id, topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        service.deleteTopic(id);
    }
}