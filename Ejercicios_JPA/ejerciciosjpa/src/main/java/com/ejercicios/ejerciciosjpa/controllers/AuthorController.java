package com.ejercicios.ejerciciosjpa.controllers;

import com.ejercicios.ejerciciosjpa.Authors;
import com.ejercicios.ejerciciosjpa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Especificamos que será un Controlador Rest y la ruta
@RestController
@RequestMapping("/authors")
public class AuthorController {

    //Extracción de los métodos que tiene AuthorService, que a su vez extrajo de AuthorRepository
    @Autowired
    private AuthorService authorService;


    //Método post para inserción de autores
    @PostMapping
    public Authors insertAuthor(@RequestBody Authors author){
        return authorService.insertAuthor(author);
    }

    //Método Get para hacer búsqueda de todos los autores añadidos
    @GetMapping
    public List<Authors> getAuthors(){
        return authorService.getAuthors();
    }
}
