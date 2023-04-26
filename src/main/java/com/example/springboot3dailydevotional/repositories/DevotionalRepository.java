package com.example.springboot3dailydevotional.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot3dailydevotional.models.Devotional;

public interface DevotionalRepository extends JpaRepository<Devotional, Long> {

  Optional<Devotional> findByPublishedAt(LocalDate date);

}
