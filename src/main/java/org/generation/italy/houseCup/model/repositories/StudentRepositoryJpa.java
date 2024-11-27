package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {
}
