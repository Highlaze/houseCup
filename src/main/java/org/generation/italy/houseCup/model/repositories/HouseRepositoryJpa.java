package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepositoryJpa extends JpaRepository<House, Long> {
}
