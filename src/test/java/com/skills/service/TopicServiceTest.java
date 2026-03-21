package com.skills.service;

import com.skills.dto.TopicDTO;
import com.skills.model.Topic;
import com.skills.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopicServiceTest {

    TopicRepository repo = Mockito.mock(TopicRepository.class);
    TopicService service = new TopicService(repo);

    @Test
    void testAddTopic() {

        TopicDTO dto = new TopicDTO();
        dto.setName("Java");
        dto.setDescription("Backend");

        Topic saved = new Topic();
        saved.setName("Java");
        saved.setDescription("Backend");

        Mockito.when(repo.save(Mockito.any())).thenReturn(saved);

        TopicDTO result = service.addTopic(dto);

        assertEquals("Java", result.getName());
        assertEquals("Backend", result.getDescription());
    }

    @Test
    void testGetAllTopics() {

        Topic t1 = new Topic();
        t1.setName("Spring");
        t1.setDescription("Framework");

        Mockito.when(repo.findAll()).thenReturn(List.of(t1));

        List<TopicDTO> result = service.getAllTopics();

        assertEquals(1, result.size());
        assertEquals("Spring", result.get(0).getName());
    }

        @Test
        void testUpdateTopic() {

            Topic existing = new Topic();
            existing.setName("Old");
            existing.setDescription("Old Desc");

            TopicDTO dto = new TopicDTO();
            dto.setName("New");
            dto.setDescription("New Desc");

            Mockito.when(repo.findById(1L)).thenReturn(java.util.Optional.of(existing));
            Mockito.when(repo.save(Mockito.any())).thenReturn(existing);

            TopicDTO result = service.updateTopic(1L, dto);

            assertEquals("New", result.getName());
        }
    @Test
    void testDeleteTopic() {

        service.deleteTopic(1L);

        Mockito.verify(repo).deleteById(1L);
    }

}
