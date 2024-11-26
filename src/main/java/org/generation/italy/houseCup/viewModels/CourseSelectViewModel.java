package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.Course;

public class CourseSelectViewModel {
    private long id;
    private String nome;

    public CourseSelectViewModel(){

    }

    public CourseSelectViewModel(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CourseSelectViewModel fromCourse(Course c){
        var cs = new CourseSelectViewModel();
        cs.setId(c.getId());
        cs.setNome(c.getClassName());
        return cs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
