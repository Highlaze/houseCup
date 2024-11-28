package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.viewModels.CourseSelectViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    private RegisterService registerService;
    @Autowired
    public CourseController(RegisterService registerService){
        this.registerService = registerService;
    }
    @GetMapping("/find-course")
    public String showCourseForm(Model model){
        List<Course> activeCourses = registerService.getActiveCourses();
        List<CourseSelectViewModel> activeCourseViewModel = activeCourses.stream()
                .map(CourseSelectViewModel::fromCourse)
                .toList();
        model.addAttribute("course",activeCourseViewModel);
        return "/course/find-course";
    }
}
