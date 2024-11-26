package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoryJpa extends JpaRepository<Course, Long>{
}
