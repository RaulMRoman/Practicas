package com.ejercicios.spring.response;

import java.time.LocalDate;
import java.util.Date;


/*Creación de la clase PersonRest, que contendrá los
atributos de cada persona.*/
public class PersonRest {
    private String firstName;
    private String firstSurName;
    private String secondSurName;
    private String completeName;
    private LocalDate birthDate;

    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstSurName() {
        return firstSurName;
    }

    public void setFirstSurName(String firstSurName) {
        this.firstSurName = firstSurName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String firstName, String firstSurName, String secondSurName) {
        this.completeName = firstName+" " +firstSurName+ " " +secondSurName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
