package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Score;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.model.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {
    private RegisterService registerService;
    private ScoreService scoreService;

    @Autowired
    public ScoreController(RegisterService registerService, ScoreService scoreService) {
        this.registerService = registerService;
        this.scoreService = scoreService;
    }
    @GetMapping("/create")
    public String createScore(Model model){
        List<Student> studentList = registerService.findAllStudents();
        model.addAttribute("STUDENT", studentList);
        model.addAttribute("SCORE", new Score());
        return "score/form";
    }
}
