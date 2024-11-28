package org.generation.italy.houseCup.model.repositories;

import org.generation.italy.houseCup.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CourseRepositoryJpa extends JpaRepository<Course, Long>{
    List<Course> findByStartDateBeforeAndEndDateAfter(LocalDate now1, LocalDate now2);
}