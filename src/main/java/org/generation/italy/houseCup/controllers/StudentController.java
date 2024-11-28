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
    private RegisterService registerService; //servizio che contiene la logica per gestire le operazioni relative a studenti, corsi e case.

    @Autowired
    public StudentController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/create") // gestisce la richiesta con metodo GET. Serve per mostrare una form (pagina) per creare un nuovo studente.
    public String showCreateForm(Model model){ //oggetto che permette di passare dati dalla logica del controller alla vista
        List<House> houses = registerService.getAllHouses(); //recupera tutte le case tramite il servizio registerService
        List<Course> courses = registerService.getAllCourses(); //recupera tutte i corsi tramite il servizio registerService
        List<HouseSelectViewModel> selectHouses = houses.stream() //Converte la lista di house in lista di oggetti view model tramite uno stream. che sono più adatti per essere utilizzati nella vista.
                .map(HouseSelectViewModel::fromHouse).toList();
        List<CourseSelectViewModel> selectCourses = courses.stream() //Converte la lista di corsi in lista di oggetti view model, tramite uno stream. che sono più adatti per essere utilizzati nella vista.
                .map(CourseSelectViewModel::fromCourse).toList();
        StudentViewModel svw = new StudentViewModel(); //Crea un oggetto StudentViewModel che rappresenta il modello per la vista (il form).
        svw.setFirstname("ciccio"); //Imposta un nome predefinito "ciccio" per il campo firstname.
        svw.setCourses(selectCourses); //Assegna le liste di corsi convertiti al view model.
        svw.setHouses(selectHouses); //Assegna le liste di case convertite al view model.
        model.addAttribute("student", svw); //aggiunge il view model svw al modello, in modo che la vista lo possa utilizzare.
        return "/student/form"; //indica l'url al quale connettersi una volta finito il metodo
    }
    @PostMapping("/create") //gestisce la richiesta con metodo POST. Viene chiamato quando l'utente invia dati alla form
    public String saveStudent(StudentViewModel sModel){ //Spring popola automaticamente questo oggetto con i dati inviati dal form.
        Student s = sModel.toStudent(); //il view model viene convertito in un'entità Student in modo da poter essere salvata sul db
        Optional<Course> oc = registerService.findCourseById(sModel.getCourseId()); //tramite il registerService va a cercare l'id del corso all'interno dell'oggetto sModel
        Optional<House> oh = registerService.findHouseById(sModel.getHouseId()); //tramite il registerService va a cercare l'id della casa all'interno dell'oggetto sModel
        if (oc.isEmpty() || oh.isEmpty()) { //se uno dei due elementi non viene trovato, ritorna un pagina view di errore
            return "/student/error";
        }
        s.setCourse(oc.get()); //prende il corso trovato, con oc.get, e lo setta nell'entità Student
        s.setHouse(oh.get()); //prende la casa trovata, con oh.get, e lo setta nell'entità Student
        registerService.saveStudent(s); //salva lo studente nel database utilizzando il servizio registerService
        //alla fine del metodo restituirà un codice 302, andando a chiedere al browser di fare un reindirizzamento verso un'altra url, ovvero /student/details, con l'id selezionato
        return "redirect:/student/details/" + s.getId(); //restituisce una redirect verso la pagina dei dettagli dello studente, utilizzando l'ID dello studente appena creato.
    }
    @GetMapping("/details/{id}") //gestisce richiesta con metodo GET, tenendosi però l'id dello studente creato -> {id}
    public String showStudentDetails (@PathVariable Long id, Model model) { //Model -> contenitore di oggetti che saranno disponibili sia alla view sia al controller
        var os = this.registerService.findStudentById(id); //Cerca lo studente nel database utilizzando l'ID passato come parametro
        if (os.isEmpty()) { //controllo nel caso lo studente non venga trovato, se fosse, restituisce pagina di errore
            return "/student/error";
        }
        StudentViewModel svm = StudentViewModel.fromStudent(os.get());  //converte l'entità Student trovata in un oggetto StudentViewModelì
        model.addAttribute("student", svm); //aggiunge il view model dello studente al modello di Thymeleaf
        return "/student/details";
    }
}
