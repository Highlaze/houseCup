package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.Student;

public class StudentSelectViewModel {
    private long id;
    private String name;

    public StudentSelectViewModel(){};

    public StudentSelectViewModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static StudentSelectViewModel fromStudent(Student s){
        var ss = new StudentSelectViewModel();
        ss.setId(s.getId());
        ss.setName("" + s.getFirstname() + " " + s.getSurname());
        return ss;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
