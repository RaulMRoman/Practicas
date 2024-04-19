package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(
        name = "authors"
)
public class Authors {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "firstName",
            columnDefinition = "TEXT"

    )
    private String firstName;

    @Column(
            name = "lastNames",
            columnDefinition = "TEXT"
    )
    private String lastNames;

    @Column(
            name = "birthDate",
            columnDefinition = "DATE"
    )
    private LocalDate birthDate;

    public Authors(){

    }

    public Authors(String firstName, String lastNames, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
