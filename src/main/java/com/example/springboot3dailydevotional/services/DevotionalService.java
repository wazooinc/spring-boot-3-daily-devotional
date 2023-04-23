package com.example.springboot3dailydevotional.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot3dailydevotional.models.Devotional;
import com.example.springboot3dailydevotional.repositories.DevotionalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DevotionalService {

  private final DevotionalRepository devotionalRepository;

  public Optional<Devotional> getDaily() {
    LocalDate today = LocalDate.now();
    return devotionalRepository.findByPublishedAt(today);
  }

  public List<Devotional> getAllDailies() {
    return devotionalRepository.findAll();
  }

  public Devotional saveDaily(Devotional devotional) {
    if (devotional.getId() == null) {
      devotional.setCreatedAt(LocalDateTime.now());
    }

    devotional.setUpdatedAt(LocalDateTime.now());
    return devotionalRepository.save(devotional);
  }
  
}
