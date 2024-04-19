package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

@Entity
@Table(
        name = "publishers"
)
public class Publishers {

    @Id
    @SequenceGenerator(
            name = "publisher_sequence",
            sequenceName = "publisher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "publisher_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "publisherName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String publisherName;
    @Column(
            name = "companyName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String companyName;

    public Publishers(){

    }
    public Publishers(String publisherName, String companyName){
        this.publisherName = publisherName;
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Publishers{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
