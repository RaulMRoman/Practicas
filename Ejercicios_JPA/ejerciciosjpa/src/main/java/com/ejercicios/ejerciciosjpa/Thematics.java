package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

//Establecemos como entidad y tabla
@Entity
@Table(
        name = "thematics"
)
public class Thematics {
    //Secuencia para el id autoincremental. El resto de apartados se indican sólo como columna con sus características
    @Id
    @SequenceGenerator(
            name = "thematic_sequence",
            sequenceName = "thematic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "thematic_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;
    @Column(
            name = "category",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String category;

    public Thematics(){

    }

    //Constructor con todos los datos
    public Thematics(String category) {
        this.category = category;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Thematics{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
