package org.generation.italy.houseCup.viewModels;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;

import java.time.LocalDate;
import java.util.List;

public class StudentViewModel {
    private long id;
    private String firstname;
    private String surname;
    private LocalDate dob;
    private char sex;
    private String mail;
    private String phone;
    private String background;
    private String education;
    private boolean isPref;
    private long courseId;
    private long houseId;
    private List<HouseSelectViewModel> houses;
    private List<CourseSelectViewModel> courses;

    public StudentViewModel(){

    }

    public StudentViewModel(long id, String firstname, String surname, LocalDate dob,
                            char sex, String mail, String phone, String background,
                            String education, boolean isPref, long courseId, long houseId) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.dob = dob;
        this.sex = sex;
        this.mail = mail;
        this.phone = phone;
        this.background = background;
        this.education = education;
        this.isPref = isPref;
        this.courseId = courseId;
        this.houseId = houseId;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean getIsPref() {
        return isPref;
    }

    public void setIsPref(boolean isPref) {
        this.isPref = isPref;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public List<HouseSelectViewModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseSelectViewModel> houses) {
        this.houses = houses;
    }

    public List<CourseSelectViewModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseSelectViewModel> courses) {
        this.courses = courses;
    }
}