package com.ejercicios.ejerciciosjpa.controllers;

import com.ejercicios.ejerciciosjpa.Books;
import com.ejercicios.ejerciciosjpa.Publishers;
import com.ejercicios.ejerciciosjpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

//Especificamos que será un Controlador Rest y la ruta
@RestController
@RequestMapping("/books")
public class BookController {

    //Extracción de los métodos que tiene BookService, que a su vez extrajo de BookRepository
    @Autowired
    private BookService bookService;

    public BookController(){
    }

    //Método post para inserción de libros
    @PostMapping
    public Books insertBook(@RequestBody Books book){
        return bookService.insertBook(book);
    }

    //Método Get para hacer búsqueda de todos los libros añadidos
    @GetMapping
    public List<Books> getBooks(){
        return bookService.getBooks();
    }

    //Get para la búsqueda por identificador (isbn) relacionado con findByIsbn en BookService
    @GetMapping(path="/yearquery={year}")
    public List<Books> findByYearQuery(@PathVariable Year year){
        return bookService.findByYearQuery(year);
    }

    //Get para la búsqueda por título, relacionado findByTitle en BookService
    @GetMapping(path="/title={title}")
    public List<Books> findByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }


    //Búsqueda por año, relacionado con findByYear en BookService
    @GetMapping(path="/year={year}")
    public List<Books> findByYear(@PathVariable Year year){
        return bookService.findByYearGreaterThan(year);
    }

    //Búsqueda por Editorial, relacionado con findByPublisher en BookService
    @GetMapping(path="/publisher={publisherName}")
    public List<Books> findByPublisher(@PathVariable String publisherName){
        return bookService.findByPublisher(publisherName);
    }

    //Búsqueda por Editorial y año, relacionado con findByPublisherAndYear en BookService
    @GetMapping(path="/publisher={publisherName}/year={year}")
    public List<Books> findByPublisherAndYear(@PathVariable String publisherName, @PathVariable Year year){
        return bookService.findByPublisherAndYear(publisherName, year);
    }
}
