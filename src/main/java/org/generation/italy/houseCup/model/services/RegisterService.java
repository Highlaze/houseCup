package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Student;

import java.util.List;
import java.util.Optional;

public interface RegisterService{

    List<Course> getAllCourses();
    List<House> getAllHouses();
    Optional<Course> findCourseById(long id);
    Optional<House> findHouseById(long id);
    Student saveStudent(Student s);
    Optional<Student> findStudentById(long id);
    List<Course> getActiveCourses();
}
