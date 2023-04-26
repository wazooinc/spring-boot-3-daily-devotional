package com.example.springboot3dailydevotional;

import com.example.springboot3dailydevotional.models.Devotional;
import com.example.springboot3dailydevotional.repositories.DevotionalRepository;
import com.example.springboot3dailydevotional.services.DevotionalService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DevotionalServiceTest {

    @Autowired
    private DevotionalService service;

    @Autowired
    private DevotionalRepository repository;

    @AfterEach
    @BeforeEach
    void deleteAllItems() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("find a given Devotional by its Id")
    void findATodoItemById() {
        // find a specific TodoItem by its id
        Devotional devo = new Devotional();
        devo.setQuote("foo");
        devo.setAuthor("bar");
        devo.setContent("test");

        devo = service.save(devo);

        Optional<Devotional> testItem = repository.findById(devo.getId());
        assertEquals(testItem.isPresent(), true);
        assertEquals(testItem.get().getId(), devo.getId());
    }

    @Test
    @DisplayName("finding all Devotionals succeeds")
    void getAllDevotionalItems() {

        Devotional item1 = new Devotional();
        item1.setContent("devo 1");

        item1 = service.save(item1);

        Devotional item2 = new Devotional();
        item2.setContent("devo 2");

        item2 = service.save(item2);

        Iterable<Devotional> items = repository.findAll();
        List<Devotional> list = new ArrayList<>();
        items.iterator().forEachRemaining(list::add);
        assertNotEquals(list.size(), 0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getId(), item1.getId());
        assertEquals(list.get(1).getId(), item2.getId());
    }

    @Test
    @DisplayName("saving a valid Devotional succeeds")
    void savingAValidDevotionalSucceeds() {
        Devotional item = new Devotional();
        item.setContent("todo item1");

        item = service.save(item);
        assertNotEquals(item.getId(), null);
    }

    @Test
    @DisplayName("finding today's Devotional succeeds")
    void getTodaysDailyDevotionalSucceeds() {
        Devotional item = new Devotional();
        item.setContent("devotional 1");
        LocalDate today = LocalDate.now();
        item.setPublishedAt(today);

        item = service.save(item);

        Optional<Devotional> testItem = service.getDaily();
        assertEquals(testItem.isPresent(), true);
        assertEquals(testItem.get().getId(), item.getId());

    }

}
