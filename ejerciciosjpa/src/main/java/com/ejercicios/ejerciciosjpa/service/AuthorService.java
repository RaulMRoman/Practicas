package com.ejercicios.ejerciciosjpa.service;

import com.ejercicios.ejerciciosjpa.Authors;
import com.ejercicios.ejerciciosjpa.interfaces.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Especificamos que será un Servicio
@Service
public class AuthorService {

    //Autowired para recoger todos los métodos incluidos en AuthorRepository / JpaRepository
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(){

    }

    //Método de Inserción extraido de AuthorRepository
    public Authors insertAuthor(Authors author){
        return authorRepository.save(author);
    }

    //Método de búsqueda de todos los autores añadidos
    public List<Authors> getAuthors(){
        return authorRepository.findAll();
    }
}
