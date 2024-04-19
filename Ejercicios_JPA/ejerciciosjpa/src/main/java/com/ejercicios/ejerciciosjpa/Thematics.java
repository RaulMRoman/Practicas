package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

@Entity
@Table(
        name = "thematics"
)
public class Thematics {

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
    public Thematics(String category) {
        this.category = category;
    }

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
