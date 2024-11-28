package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.entities.Teacher;
import org.generation.italy.houseCup.model.repositories.CourseRepositoryJpa;
import org.generation.italy.houseCup.model.repositories.HouseRepositoryJpa;
import org.generation.italy.houseCup.model.repositories.StudentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceJpa implements RegisterService{
    private CourseRepositoryJpa courseRepo;
    private HouseRepositoryJpa houseRepo;
    private StudentRepositoryJpa studentRepo;

    @Autowired
    public RegisterServiceJpa(CourseRepositoryJpa courseRepo, HouseRepositoryJpa houseRepo, StudentRepositoryJpa studentRepo){
        this.courseRepo = courseRepo;
        this.houseRepo = houseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepo.findAll();
    }

    @Override
    public Optional<Course> findCourseById(long id) {
        return courseRepo.findById(id);
    }

    @Override
    public Optional<House> findHouseById(long id) {
        return houseRepo.findById(id);
    }

    @Override
    public List<Teacher> findAllTeachers() { // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah
        return List.of();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepo.save(s);
    }

    @Override
    public Optional<Student> findStudentById(long id) {
        return studentRepo.findById(id);
    }
}
