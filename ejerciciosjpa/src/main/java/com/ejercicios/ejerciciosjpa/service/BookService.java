package com.ejercicios.ejerciciosjpa.service;

import com.ejercicios.ejerciciosjpa.Authors;
import com.ejercicios.ejerciciosjpa.Books;
import com.ejercicios.ejerciciosjpa.Publishers;
import com.ejercicios.ejerciciosjpa.interfaces.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Year;
import java.util.List;

//Especificamos que será un Servicio
@Service
public class BookService {

    //Autowired para recoger todos los métodos incluidos en BookRepository / JpaRepository
    @Autowired
    private BookRepository bookRepository;

    public BookService(){
    }

    //Todos los siguientes métodos los recogerá BookController


    //Método de Inserción extraido de BookRepository
    public Books insertBook(Books book){
        return bookRepository.save(book);
    }

    //Método de búsqueda de todos los libros añadidos
    public List<Books> getBooks(){
        return bookRepository.findAll();
    }


    //Búsqueda por identificador (isbn) creaco con @Query en BookRepository
    public Books encuentra(Integer isbn){
        return bookRepository.findByIsbn(isbn);
    }

    //Búsqueda por título, relacionado con el método findByTitle creado en BookRepository
    public List<Books> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Books> findByYear(Year year){
        return bookRepository.findByYear(year);
    }

    public List<Books> findByPublisher(String publisherName){
        return bookRepository.findByPublisher(publisherName);
    }

    public List<Books> findByPublisherAndYear(String publisherName, Year year){
        return bookRepository.findByPublisherAndYear(publisherName, year);
    }
}
