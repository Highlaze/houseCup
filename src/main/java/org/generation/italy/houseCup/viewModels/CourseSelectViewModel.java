package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.Course;

public class CourseSelectViewModel {
    private long id;
    private String name;

    public CourseSelectViewModel(){

    }

    public CourseSelectViewModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CourseSelectViewModel fromCourse(Course c){
        var cs = new CourseSelectViewModel();
        cs.setId(c.getId());
        cs.setName(c.getClassName());
        return cs;
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
