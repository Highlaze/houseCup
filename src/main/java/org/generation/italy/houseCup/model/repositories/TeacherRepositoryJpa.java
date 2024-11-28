package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositoryJpa extends JpaRepository<Teacher, Long> {
}
