package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.entities.Teacher;

import java.time.LocalDate;
import java.util.List;

public class ScoreViewModel {
    private long id;
    private List<Student> students;
    private long studentId;
    private int points;
    private String motivation;
    private LocalDate assign_date;
    private long teacherId = 1;

    public ScoreViewModel(){};

    public ScoreViewModel(long id,long studentId, int points, String motivation, LocalDate assign_date, long teacherId) {
        this.id = id;
        this.studentId = studentId;
        this.points = points;
        this.motivation = motivation;
        this.assign_date = assign_date;
        this.teacherId = teacherId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public LocalDate getAssign_date() {
        return assign_date;
    }

    public void setAssign_date(LocalDate assign_date) {
        this.assign_date = assign_date;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
