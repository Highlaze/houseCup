package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Score;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.entities.Teacher;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.model.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        List<Teacher> teacherList = registerService.findAllTeachers();
        List<Student> studentList = registerService.findAllStudents();

        model.addAttribute("TEACHER", teacherList);
        model.addAttribute("STUDENT", studentList);
        model.addAttribute("SCORE", new Score());
        return "/score/form";
    }

    @PostMapping("/create")
    public String saveScore(@ModelAttribute ("SCORE") Score score) {
        Score savedScore = this.scoreService.save(score);
        return "redirect:/score/details/" + savedScore.getId();
    }

    @GetMapping("/details/{id}")
    public String showScore(@PathVariable Long id, Model model) {
        Optional<Score> score = this.scoreService.findById(id);
        if(score.isEmpty()) {
            return "/score/error";
        }
        model.addAttribute("SCORE", score.get());
        return "/score/details";
    }


}
