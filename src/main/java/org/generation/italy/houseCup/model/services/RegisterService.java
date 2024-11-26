package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;

import java.util.List;

public interface RegisterService{

    List<Course> getAllCourses();
    List<House> getAllHouses();

}
