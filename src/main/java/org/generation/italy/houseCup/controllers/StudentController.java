package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.viewModels.CourseSelectViewModel;
import org.generation.italy.houseCup.viewModels.HouseSelectViewModel;
import org.generation.italy.houseCup.viewModels.StudentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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
        svw.setFirstname("ciccio");
        svw.setCourses(selectCourses);
        svw.setHouses(selectHouses);
        model.addAttribute("student", svw);
        return "/student/form";
    }
    @PostMapping("/create")
    public String saveStudent(StudentViewModel sModel){
        Student s = sModel.toStudent();
        //Trova il corso selezionato utilizzando l'ID del corso presente nel view model
        Optional<Course> oc = registerService.findCourseById(sModel.getCourseId());
        Optional<House> oh = registerService.findHouseById(sModel.getHouseId());
        // Controlla se il corso o la casata non sono stati trovati
        if (oc.isEmpty() || oh.isEmpty()) {
            return "/student/error";
        }
        // Imposta il corso trovato nell'entità Student
        s.setCourse(oc.get());
        s.setHouse(oh.get());
        registerService.saveStudent(s);
        //alla fine del metodo restituirà un codice 302, andando a chiedere al browser di fare un reindirizzamento verso un'altra url, ovvero /student/details, con l'id selezionato
        return "redirect:/student/details/" + s.getId();
    }
    @GetMapping("/details/{id}")
    public String showStudentDetails (@PathVariable Long id, Model model) { //Model -> contenitore di oggetti che saranno disponibili sia alla view sia al controller
        // Trova lo studente nel database utilizzando l'ID passato come parametro
        var os = this.registerService.findStudentById(id);
        if (os.isEmpty()) {
            return "/student/error";
        }
        // Converte l'entità Student trovata in un oggetto StudentViewModel
        StudentViewModel svm = StudentViewModel.fromStudent(os.get());
        // Aggiunge il view model dello studente al modello di Thymeleaf
        model.addAttribute("student", svm);
        return "/student/details";
    }
}
