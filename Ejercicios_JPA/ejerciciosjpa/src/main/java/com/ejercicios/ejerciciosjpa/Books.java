package com.ejercicios.ejerciciosjpa;

import jakarta.persistence.*;

import java.time.Year;


//Lo establecemos como Entidad y lo creamos como tabla
@Entity(name = "Books")
@Table(
        name = "books"
)
public class Books {

    //Creamos la secuencia autoincremental para el ID
    //Al resto de campos le decimos sólo que serán Columnas, le pasamos nombre y características que tendrán
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

    //Establecemos las relaciones con un atributo que será el objeto de la clases con las que se relaciona
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

    //Constructor con todos los datos
    public Books(String title, Year year, Authors author, Publishers publisher, Thematics thematic) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.publisher = publisher;
        this.thematic = thematic;
    }

    //Getters y Setters
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


    //Método toString, aunque no hacemos uso de él en estos ejercicios.
    @Override
    public String toString() {
        return "Books{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", publisher=" + publisher +
                ", thematic=" + thematic +
                '}';
    }
}
