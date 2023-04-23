package com.example.springboot3dailydevotional.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboot3dailydevotional.models.Devotional;
import com.example.springboot3dailydevotional.services.DevotionalService;

@Component
public class SeedData implements CommandLineRunner {

  @Autowired
  private DevotionalService devotionalService;
  
  @Override
  public void run(String... args) throws Exception {

    List<Devotional> devotions = devotionalService.getAllDailies();

    if (devotions.size() < 1) {
      Devotional devo1 = new Devotional();
      devo1.setTitle("title 1");
      devo1.setImagePath("images/img1.jpg");
      devo1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      devo1.setPublishedAt(LocalDate.now());
      devo1 = devotionalService.saveDaily(devo1);

      Devotional devo2 = new Devotional();
      devo2.setTitle("title 2");
      devo2.setImagePath("images/img2.jpg");
      devo2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      devo2.setPublishedAt(LocalDate.now().plusDays(1));
      devo2 = devotionalService.saveDaily(devo2);

      Devotional devo3 = new Devotional();
      devo3.setTitle("title 3");
      devo3.setImagePath("images/img3.jpg");
      devo3.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      devo3.setPublishedAt(LocalDate.now().plusDays(2));
      devo3 = devotionalService.saveDaily(devo3);

    }


  }


}
