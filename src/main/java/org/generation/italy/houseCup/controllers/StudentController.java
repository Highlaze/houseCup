package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.viewModels.CourseSelectViewModel;
import org.generation.italy.houseCup.viewModels.HouseSelectViewModel;
import org.generation.italy.houseCup.viewModels.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private RegisterService registerService;

    @Autowired
    public StudentController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        List<House> houses = registerService.getAllHouses();
        List<Course> courses = registerService.getAllCourses();
        List<HouseSelectViewModel> selectHouses = houses.stream()
                .map(HouseSelectViewModel::fromHouse).toList();
        List<CourseSelectViewModel> selectCourses = courses.stream()
                .map(CourseSelectViewModel::fromCourse).toList();
        StudentViewModel svw = new StudentViewModel();
        svw.setCourses(selectCourses);
        svw.setHouses(selectHouses);
        model.addAttribute("student", svw);
        return "/student/form";
    }


}
