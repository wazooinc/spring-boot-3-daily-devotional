package com.example.springboot3dailydevotional.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot3dailydevotional.models.Devotional;

public interface DevotionalRepository extends JpaRepository<Devotional, Long> {

  public Optional<Devotional> findByPublishedAt(LocalDate date);
  public List<Devotional> findAll();

}
