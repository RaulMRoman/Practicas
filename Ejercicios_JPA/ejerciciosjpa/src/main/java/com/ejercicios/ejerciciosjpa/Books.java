package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

import java.time.Year;


@Entity(name = "Books")
@Table(
        name = "books"
)
public class Books {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "isbn",
            updatable = false
    )
    private Long isbn;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name="year",
            nullable = false,
            columnDefinition = "YEAR"
    )
    private Year year;

    @ManyToOne
    @JoinColumn(name="idAuthor")
    private Authors author;

    @ManyToOne
    @JoinColumn(name="idPublisher")
    private Publishers publisher;

    @ManyToOne
    @JoinColumn(name="idThematic")
    private Thematics thematic;

    public Books(){

    }

    public Books(String title, Year year, Authors author, Publishers publisher, Thematics thematic) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.publisher = publisher;
        this.thematic = thematic;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }

    public Thematics getThematic() {
        return thematic;
    }

    public void setThematic(Thematics thematic) {
        this.thematic = thematic;
    }
}
