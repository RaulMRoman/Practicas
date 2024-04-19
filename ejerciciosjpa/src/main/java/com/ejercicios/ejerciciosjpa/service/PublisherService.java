package com.ejercicios.ejerciciosjpa.service;

import com.ejercicios.ejerciciosjpa.Publishers;
import com.ejercicios.ejerciciosjpa.interfaces.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//Especificamos que será un Servicio
@Service
public class PublisherService {

    //Autowired para recoger todos los métodos incluidos en PublisherRepository / JpaRepository
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherService(){

    }

    //Método de Inserción extraido de PublisherRepository
    public Publishers insertPublisher(Publishers publisher){
        return publisherRepository.save(publisher);
    }

    //Método de búsqueda de todas las editoriales añadidas
    public List<Publishers> getPublishers(){
        return publisherRepository.findAll();
    }
}
