package com.ejercicios.ejerciciosjpa.controllers;

import com.ejercicios.ejerciciosjpa.Publishers;
import com.ejercicios.ejerciciosjpa.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Especificamos que será un Controlador Rest y la ruta
@RestController
@RequestMapping("/publishers")
public class PublisherController {

    //Extracción de los métodos que tiene PublisherService, que a su vez extrajo de PublisherRepository
    @Autowired
    private PublisherService publisherService;

    //Método post para inserción de editoriales
    @PostMapping
    public Publishers insertPublisher(@RequestBody Publishers publisher){
        return publisherService.insertPublisher(publisher);
    }

    //Método Get para hacer búsqueda de todos las editoriales añadidas
    @GetMapping
    public List<Publishers> getPublishers(){
        return publisherService.getPublishers();
    }
}
