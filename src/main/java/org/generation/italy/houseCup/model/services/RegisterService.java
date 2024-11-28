package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface RegisterService{

    List<Course> getAllCourses();
    List<House> getAllHouses();
    Optional<Course> findCourseById(long id);
    Optional<House> findHouseById(long id);
    List<Student> findAllStudents();
    List<Teacher> findAllTeachers(); // ricordiamo di implementare teacher
    Student saveStudent(Student s);
    Optional<Student> findStudentById(long id);
}