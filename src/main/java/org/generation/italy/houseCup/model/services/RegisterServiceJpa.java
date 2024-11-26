package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.repositories.CourseRepositoryJpa;
import org.generation.italy.houseCup.model.repositories.HouseRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceJpa implements RegisterService{
    private CourseRepositoryJpa courseRepo;
    private HouseRepositoryJpa houseRepo;

    @Autowired
    public RegisterServiceJpa(CourseRepositoryJpa courseRepo, HouseRepositoryJpa houseRepo){
        this.courseRepo = courseRepo;
        this.houseRepo = houseRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepo.findAll();
    }
}
