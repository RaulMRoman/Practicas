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

    //Get para la búsqueda por identificador (isbn) creaco con @Query en BookRepository
    @GetMapping(path="/isbn={isbn}")
    public Books findByIsbn(@PathVariable Integer isbn){
        return bookService.encuentra(isbn);
    }

    //Get para la búsqueda por título, relacionado con el método findByTitle creado en BookRepository
    @GetMapping(path="/title={title}")
    public List<Books> findByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }

    @GetMapping(path="/year={year}")
    public List<Books> findByYear(@PathVariable Year year){
        return bookService.findByYear(year);
    }

    @GetMapping(path="/publisher={publisherName}")
    public List<Books> findByPublisher(@PathVariable String publisherName){
        return bookService.findByPublisher(publisherName);
    }

    @GetMapping(path="/publisher={publisherName}/year={year}")
    public List<Books> findByPublisherAndYear(@PathVariable String publisherName, @PathVariable Year year){
        return bookService.findByPublisherAndYear(publisherName, year);
    }
}
