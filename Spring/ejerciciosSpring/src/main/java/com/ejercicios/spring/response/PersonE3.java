package com.ejercicios.spring.response;

import java.time.LocalDate;

public class PersonE3 {

    private int dni;
    private String name;
    private String firstSurName;
    private String secondSurName;
    private String completeName;
    private LocalDate birthDate;
    private String gender;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCompleteName() {
        this.completeName = this.getName()+" "+this.getFirstSurName()+" "+this.getSecondSurName();
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
