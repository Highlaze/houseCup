package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.viewModels.ScoreViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private RegisterService registerService;
    public ScoreController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @GetMapping("/create")
    String showForm(@RequestParam("courseId") Long id, Model model) { //RequestParam serve a recuperare l'id che è risultato nella form
        List<Student> students = registerService.findStudentByCourseId(id);
        ScoreViewModel svm = new ScoreViewModel();
        svm.setStudents(students);
        model.addAttribute("score", svm);
        return "/score/assign-score";
    }
}
