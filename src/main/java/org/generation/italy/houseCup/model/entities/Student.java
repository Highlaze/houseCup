package org.generation.italy.houseCup.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private long id;
    private String firstname;
    private String surname;
    private LocalDate dob;
    private char sex;
    private String mail;
    private String phone;
    @Column(name = "bg")
    private String background;
    private String education;
    @Column(name = "is_pref")
    private boolean isPref;
    @ManyToOne
    @JoinColumn(name="class_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name="house_id")
    private House house;

    public Student() {
    }

    public Student(long id, String firstname, String surname,
                   LocalDate dob, char sex, String mail, String phone,
                   String background, String education, boolean isPref,
                   House house, Course course) {
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
        this.house = house;
        this.course = course;
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

}
