package com.skills.controller;

import com.skills.dto.TopicDTO;
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
    public List<TopicDTO> getAllTopics() {   // ✅ FIXED
        return service.getAllTopics();
    }

    @PostMapping("/add")
    public TopicDTO addTopic(@RequestBody TopicDTO dto) {   // ✅ FIXED
        return service.addTopic(dto);
    }

    @PutMapping("/{id}")
    public TopicDTO updateTopic(@PathVariable Long id, @RequestBody TopicDTO dto) {   // ✅ FIXED
        return service.updateTopic(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        service.deleteTopic(id);
    }
}