package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepositoryJpa extends JpaRepository<Score, Long> {
}
